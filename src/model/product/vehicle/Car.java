package model.product.vehicle;

import model.ModelData;

public class Car extends Vehicle {

    private int engineVolume;
    private boolean automaticGearbox;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Car(String companyName,int EngineVolume, boolean automaticGearbox,String name, int nmbrAvailable,double price){

        super(companyName,name,nmbrAvailable,price);

        this.engineVolume = EngineVolume;
        this.automaticGearbox = automaticGearbox;

        //set ID
        this.ID = new StringBuilder(companyName+"-"+name+"-"+engineVolume);

        ModelData.getProducts().add(this);
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
}
