package com.example.bmi_calculator;

public class JSON_File {
    private double bmi;
    private String risk;
    private String[] more;

    public JSON_File () {
        bmi = 0.00;
        risk = "";
        more = new String[2];
    }

    public void putBMI (double InputBMI) {
        bmi = InputBMI;
    }

    public void putRisk (String InputRisk) {
        risk = InputRisk;
    }

    public void putMore (String[] InputMore) {
        more = InputMore;
    }

    public double getBMI () {
        return bmi;
    }

    public String getRisk() {
        return risk;
    }

    public String[] getMore() {
        return more;
    }


}
