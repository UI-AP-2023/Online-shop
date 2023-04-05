package model.product.stationerySupplies;

import model.ModelData;

public class Pen extends StationerySupplies {

    private String color;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Pen(String country,String color, String name, int nmbrAvailable,double price) {
        super(country,name, nmbrAvailable,price);
        this.color = color;

        //set ID for every object with its properties
        this.ID=new StringBuilder(this.getClass().getName()+"-"+name+"-"+color+"-"+country);

        ModelData.getProducts().add(this);

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
