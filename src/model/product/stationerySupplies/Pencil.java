package model.product.stationerySupplies;

import model.ModelData;
import model.product.ProductCategory;

public class Pencil extends StationerySupplies {

    private PencilType type;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Pencil(String country, PencilType type, String name, int nmbrAvailable,double price) {
        super(country, name, nmbrAvailable,price);
        this.type = type;

        //set ID for every object with its properties
        this.ID=new StringBuilder(this.getClass().getName()+"-"+name+"-"+type.toString()+"-"+country);

        ModelData.getProducts().add(this);

        this.category= ProductCategory.PENCIL;

    }

    public PencilType getType() {
        return type;
    }

    public void setType(PencilType type) {
        this.type = type;
    }
}

