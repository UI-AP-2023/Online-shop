package com.example.fase2.model.product.stationerySupplies;


import com.example.fase2.model.ModelData;
import com.example.fase2.model.product.Product;

public abstract class StationerySupplies extends Product {

    private String country;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    StationerySupplies(String country, String name, int nmbrAvailable,double price) {
        super(name,nmbrAvailable,price);

        this.country = country;

        ModelData.getStationerySupplies().add(this);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

