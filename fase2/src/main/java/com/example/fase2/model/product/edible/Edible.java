package com.example.fase2.model.product.edible;


import com.example.fase2.model.ModelData;
import com.example.fase2.model.product.Product;
import com.example.fase2.model.product.ProductCategory;

public class Edible extends Product {

    private String produceDate, ExpirationDate;
    private static int staticID=1;

    //0000000000000000000000000000000000000000000000000===constructor

    public Edible(String produceDate, String ExpirationDate, String name, int numberOfAvailable, double price){

        super(name, numberOfAvailable,price);

        this.produceDate = produceDate;
        this.ExpirationDate = ExpirationDate;

        //set ID for every object with its properties
        this.ID = new StringBuilder(name+staticID);
        staticID++;

        ModelData.getProducts().add(this);

        this.category= ProductCategory.EDIBLE;

    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        ExpirationDate = expirationDate;
    }
}
