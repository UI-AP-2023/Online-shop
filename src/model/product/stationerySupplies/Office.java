package model.product.stationerySupplies;

import model.ModelData;
import model.product.ProductCategory;

public class Office extends StationerySupplies {

    private int numberOfSheets;
    private String paperType;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Office(String country, int numberOfSheets, String paperType, String name, int nmbrAvailable,double price) {
        super(country,name,nmbrAvailable,price);
        this.numberOfSheets = numberOfSheets;
        this.paperType = paperType;

        //set ID for every object with its properties
        this.ID = new StringBuilder(this.getClass().getName()+"-"+name+"-"+numberOfSheets+"Sheets-"+paperType+"-"+country);

        ModelData.getProducts().add(this);

        this.category= ProductCategory.OFFICE;

    }

    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    public void setNumberOfSheets(int numberOfSheets) {
        this.numberOfSheets = numberOfSheets;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }
}