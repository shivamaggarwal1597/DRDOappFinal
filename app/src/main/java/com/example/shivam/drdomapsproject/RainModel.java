package com.example.shivam.drdomapsproject;

/**
 * Created by shivam on 9/7/18.
 */

public class RainModel {
    public double rain_fall = 0.00;
    public int hours = 0;

    public RainModel() {
    }

    public double getRain_fall() {
        return rain_fall;
    }

    public void setRain_fall(double rain_fall) {
        this.rain_fall = rain_fall;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public RainModel(double rain_fall, int hours) {
        this.rain_fall = rain_fall;
        this.hours = hours;
    }
}
