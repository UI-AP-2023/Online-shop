package model.product.stationerySupplies;

import model.product.Product;
public abstract class StationerySupplies extends Product {

    private String country;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    StationerySupplies(String country, String name, int nmbrAvailable,double price) {
        super(name,nmbrAvailable,price);

        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

