package com.example.shivam.drdomapsproject;

import java.util.ArrayList;
import java.util.List;

import az.openweatherapi.model.gson.common.Coord;

/**
 * Created by shivam on 11/7/18.
 */

public class DAOModel {

    List<LocationModel> location_models ;

    public List<LocationModel> getLocation_models() {
        return location_models;
    }

    public void setLocation_models(List<LocationModel> location_models) {
        this.location_models = location_models;
    }

    public DAOModel() {
        location_models =new ArrayList<>();
    }



}
