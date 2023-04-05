package model.product.vehicle;

import model.ModelData;

public class Bike extends Vehicle{

    private BikeType type;

    Bike(String companyName,String name, int nmbrAvailable, BikeType type,double price) {

        super(companyName,name,nmbrAvailable,price);
        this.type = type;

        //set id
        this.ID= new StringBuilder(companyName+"-"+name+"-"+type.toString());

        ModelData.getProducts().add(this);

    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }
}
