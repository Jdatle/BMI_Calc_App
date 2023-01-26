using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace BMICalcREST
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "BMICalc" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select BMICalc.svc or BMICalc.svc.cs at the Solution Explorer and start debugging.
    public class BMICalc : IBMICalc
    {
        public double myBMI(int height, int weight)
        {
            double bmi = 703 * weight / (height * height);
            return bmi;
        }

        public bmi myHealth(int height, int weight)
        {
            bmi health = new bmi();
            string[] more = { "https://www.cdc.gov/healthyweight/assessing/bmi/index.html", "https://www.nhlbi.nih.gov/health/educational/lose_wt/index.htm",
                            "https://www.ucsfhealth.org/education/body_mass_index_tool/"};

            string myRisk = "Error, Please try again.";

            health.BMI = myBMI(height, weight);

            if (health.BMI < 18)
            {
                myRisk = "You are underweight BMI < 18 - Blue Color";
            }

            if (health.BMI >= 18 && health.BMI < 25)
            {
                myRisk = "Your weight is normal 25 > BMI >= 18 - Green Color";
            }

            if (health.BMI >= 25 && health.BMI < 30)
            {
                myRisk = "You are pre-obese 30 > BMI >= 25 - Purple Color";
            }

            if (health.BMI > 30)
            {
                myRisk = "You are obese BMI - Red Color";
            }

            health.Risk = myRisk;
            health.More = more;

            return health;
        }
    }
}
