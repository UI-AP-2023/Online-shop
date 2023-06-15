package com.example.phase2.model.product.edible;


import com.example.phase2.model.ModelData;
import com.example.phase2.model.product.Product;
import com.example.phase2.model.product.ProductCategory;

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


        this.category= ProductCategory.EDIBLE;

        ModelData.getProducts().add(this);
        ModelData.getEdibles().add(this);
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

    @Override
    public String toString() {
        return "\nEdible{" +
                "\nproduceDate='" + produceDate + '\'' +
                "\nExpirationDate='" + ExpirationDate + '\'' +
                "\nID=" + ID +
                "\nname='" + name + '\'' +
                "\nprice=" + price +
                "\nnumberOfAvailable=" + numberOfAvailable +
                "\nbuyersScores=" + this.getAverageScore() +
                "\nnumber=" + number +
                "}\n\n";
    }
}
