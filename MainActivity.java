package com.example.bmi_calculator;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView txtLabel, txtMessage;
    private EditText edtTxtHeight, edtTxtWeight;
    private WebView web;

    BMIController bmiController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Buttons
        Button buttonCall = findViewById(R.id.buttonCallAPI);
        buttonCall.setOnClickListener(this);

        Button buttonLearn = findViewById(R.id.buttonLearn);
        buttonLearn.setOnClickListener(this);

        // Set Views
        txtLabel = findViewById(R.id.txtViewLabel);
        txtMessage = findViewById(R.id.txtViewMessage);

        edtTxtHeight = findViewById(R.id.editTextHeight);
        edtTxtWeight = findViewById(R.id.editTextWeight);
        web = findViewById(R.id.webView);

        // Controller
        bmiController = new BMIController(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonCallAPI:
                Editable heightInput = edtTxtHeight.getText();
                Editable weightInput = edtTxtWeight.getText();
                CallAPI(heightInput,weightInput);
                break;

            case R.id.buttonLearn:
                Learn();
                break;
            default:
                break;
        }

    }

    private void CallAPI(Editable height, Editable weight) {
        bmiController.callAPI(height,weight);

    }

    private void Learn() {
       bmiController.callEducate();
    }

}

