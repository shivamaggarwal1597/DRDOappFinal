package com.example.shivam.drdomapsproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shivam on 19/7/18.
 */
public class DAOmodelShapeFile {

    public List<ShapeListModel> shapeListModels;

    public DAOmodelShapeFile(List<ShapeListModel> shapeListModels) {

        this.shapeListModels = shapeListModels;

    }

    public DAOmodelShapeFile() {
        shapeListModels = new ArrayList<>();
    }

    public List<ShapeListModel> getShapeListModels() {
        return shapeListModels;
    }

    public void setShapeListModels(List<ShapeListModel> shapeListModels) {
        this.shapeListModels = shapeListModels;
    }
}