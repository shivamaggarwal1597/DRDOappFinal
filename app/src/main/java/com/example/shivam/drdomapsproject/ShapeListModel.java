package com.example.shivam.drdomapsproject;
public class ShapeListModel {

    public String shape_file_name;
    public String shape_file_details;
    public String show_name;
    public boolean selected_to_show;

    public boolean isSelected_to_show() {
        return selected_to_show;
    }

    public void setSelected_to_show(boolean selected_to_show) {
        this.selected_to_show = selected_to_show;
    }

    public String getShow_name() {
        return show_name;
    }

    public void setShow_name(String show_name) {
        this.show_name = show_name;
    }

    public ShapeListModel() {
    }

    public String getShape_file_name() {
        return shape_file_name;
    }

    public void setShape_file_name(String shape_file_name) {
        this.shape_file_name = shape_file_name;
    }

    public String getShape_file_details() {
        return shape_file_details;
    }

    public void setShape_file_details(String shape_file_details) {
        this.shape_file_details = shape_file_details;
    }

    public ShapeListModel(String shape_file_name, String shape_file_details,String show_name) {
        this.shape_file_name = shape_file_name;
        this.shape_file_details = shape_file_details;
        this.show_name = show_name;
        selected_to_show = false;
    }
}