package model.product.vehicle;

import model.product.Product;
import model.product.ProductCategory;

public abstract class Vehicle extends Product {

    private String companyName;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Vehicle(String companyName, String name, int nmbrAvailable,double price){

        super(name, nmbrAvailable,price);
        this.companyName = companyName;
    }

    static void SetCategory(){
        category = ProductCategory.VEHICLE;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
