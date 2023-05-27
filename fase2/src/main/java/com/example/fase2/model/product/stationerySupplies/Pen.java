package com.example.fase2.model.product.stationerySupplies;


import com.example.fase2.model.ModelData;
import com.example.fase2.model.product.ProductCategory;

public class Pen extends StationerySupplies {

    private String color;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    public Pen(String country, String color, String name, int nmbrAvailable, double price) {
        super(country,name, nmbrAvailable,price);
        this.color = color;

        //set ID for every object with its properties
        this.ID=new StringBuilder(this.getClass().getName()+"-"+name+"-"+color+"-"+country);

        ModelData.getProducts().add(this);

        this.category= ProductCategory.PEN;

        ModelData.getPens().add(this);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
