package com.example.bmi_calculator;

import android.content.Intent;
import android.net.Uri;
import android.text.Editable;

public class BMIController {
    private MainActivity mainActivity;
    private BMIModel model;

    public BMIController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        model = new BMIModel(this);
    }

    public void callAPI(Editable height, Editable weight) {
        model.callAPI(height,weight);
    }

    public void callEducate() {
        model.callEducate();
    }

    public void onCallModel(String bmiString, String message, int color) {
        this.mainActivity.txtLabel.setText(bmiString);
        this.mainActivity.txtMessage.setText(message);
        this.mainActivity.txtMessage.setTextColor(color);
    }

    public void onEducateModel(String link) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        this.mainActivity.startActivity(browserIntent);
    }

}
