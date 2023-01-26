package com.example.bmi_calculator;

import android.graphics.Color;
import android.telecom.Call;
import android.text.Editable;
import android.widget.Toast;

public class BMIModel {

    private  BMIController controller;

    JSON_File appIncomingJSON = new JSON_File();
    double bmi;
    String risk;
    String[] more;

    public BMIModel(BMIController controller) {
        this.controller = controller;
    }


    public void callAPI(Editable heightInput, Editable weightInput)
    {
        // Check to make sure text fields are not empty
        if(heightInput.toString().isEmpty() || weightInput.toString().isEmpty()) {
        } else
        {
            // Check to make sure text fields are greater than zero
            int height = (int) Math.round(Double.parseDouble(heightInput.toString()));
            int weight = (int) Math.round(Double.parseDouble(weightInput.toString()));
            if (height > 0 && weight > 0)
            {

                Call_BMI_API(height, weight);

                // Get Received JSON File & Parse to get bmi, risk, & more

                bmi = appIncomingJSON.getBMI();
                risk = appIncomingJSON.getRisk();
                more = appIncomingJSON.getMore();
                callAPI_To_Controller();
            }
        }
    }

    public void callEducate() {
        controller.onEducateModel(more[0]);
    }

    private void callAPI_To_Controller() {
        // Convert BMI to string

        String bmiString = String.valueOf(bmi);
        // Based on Part 1 response, does not send a color back in JSON file,
        // Determine the color & message based on the result of "risk"

        int color = 0;
        String message = "";
        switch (risk) {
            case "You are underweight BMI < 18 - Blue Color":
                color = Color.BLUE;
                message = "You are underweight";
                break;
            case "Your weight is normal 25 > BMI >= 18 - Green Color":
                color = 0xFF218E49;
                message = "You are normal";
                break;
            case "You are pre-obese 30 > BMI >= 25 - Purple Color":
                color = 0xFF5C2AB8;
                message = "You are pre-obese";
                break;
            case "You are obese BMI - Red Color":
                color = Color.RED;
                message = "You are obese";
                break;
            default:
                break;
        }

        // BMI String , risk, & message color back to controller
        controller.onCallModel(bmiString,message,color);
    }


    public String Call_BMI_API(int height, int weight)
    {
        // Unfortunately unable to get localhost to connect to android studio emulator =(
        // I think this was because I was unable to replace
        // localhost:port wth <Local IP Address>:port
        // Had to stop b/c online tutorials/videos were starting to mess up basic cpu functions

        // Below is a simulation on how I would of expected to perform the API call
//        String baseURL = "http://10.0.2.2:62961/BMICalc.svc";
        String baseURL = "http://10.0.2.2:59589/BMICalc.svc";
        String SendingURL = baseURL + "/myHealth?height=" + height + "&weight=" + weight;
        // Parse URI link & send

        // Sending variables to simulated API
        BMI_Calc_Simulated_API(height,weight);
        return SendingURL;
    }


    private JSON_File BMI_Calc_Simulated_API(int height, int weight)
    {
        // Simulated API, gets int data & then sends back JSON_File

        // BMI Calc API calculates BMI
        double bmi = 703 * weight / (height * height);
        appIncomingJSON.putBMI(bmi);


        // BMI Calc API Calculates Risk Message
        String message = "";

        if (bmi < 18) {
            message = "You are underweight BMI < 18 - Blue Color";
        }

        if (bmi >= 18 && bmi < 25) {
            message = "Your weight is normal 25 > BMI >= 18 - Green Color";
        }

        if (bmi >= 25 && bmi < 30) {
            message = "You are pre-obese 30 > BMI >= 25 - Purple Color";
        }

        if (bmi > 30) {
            message = "You are obese BMI - Red Color";
        }

        appIncomingJSON.putRisk(message);


        // BMI Calc API Provides extra links
        String[] moreLinks =
                {
                        "https://www.cdc.gov/healthyweight/assessing/bmi/index.html",
                        "https://www.nhlbi.nih.gov/health/educational/lose_wt/index.htm",
                        "https://www.ucsfhealth.org/education/body_mass_index_tool/"
                };

        appIncomingJSON.putMore(moreLinks);

        return appIncomingJSON;
    }


}
