package com.example.phase2.model.product.vehicle;


import com.example.phase2.model.ModelData;
import com.example.phase2.model.product.Product;

public abstract class Vehicle extends Product {

    private String companyName;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Vehicle(String companyName, String name, int nmbrAvailable,double price){

        super(name, nmbrAvailable,price);
        this.companyName = companyName;

        ModelData.getVehicles().add(this);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
