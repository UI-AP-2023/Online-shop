package com.example.phase2.model.product.vehicle;


import com.example.phase2.model.ModelData;
import com.example.phase2.model.product.ProductCategory;

public class Car extends Vehicle {

    private int engineVolume;
    private boolean automaticGearbox;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    public Car(String companyName, int EngineVolume, boolean automaticGearbox, String name, int nmbrAvailable, double price){

        super(companyName,name,nmbrAvailable,price);

        this.engineVolume = EngineVolume;
        this.automaticGearbox = automaticGearbox;

        //set ID
        this.ID = new StringBuilder(companyName+"-"+name+"-"+engineVolume);

        ModelData.getProducts().add(this);

        this.category= ProductCategory.CAR;

        ModelData.getCars().add(this);
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public boolean isAutomaticGearbox() {
        return automaticGearbox;
    }

    public void setAutomaticGearbox(boolean automaticGearbox) {
        this.automaticGearbox = automaticGearbox;
    }

    @Override
    public String toString() {
        return "Car{" +
                "\nengineVolume=" + engineVolume +
                "\nautomaticGearbox=" + automaticGearbox +
                "\nID=" + ID +
                "\nname='" + name + '\'' +
                "\nBuyers score="+this.getAverageScore()+
                "\nprice=" + price +
                "\nnumberOfAvailable=" + numberOfAvailable +
                "\nnumber=" + number +
                "}\n\n";
    }
}
