package com.example.phase2.model.product.stationerySupplies;


import com.example.phase2.model.Discount.Discountable;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.product.ProductCategory;

public class Pencil extends StationerySupplies implements Discountable {

    private PencilType type;
    private static int discountPercent;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    public Pencil(String country, PencilType type, String name, int nmbrAvailable, double price) {
        super(country, name, nmbrAvailable, price);
        this.type = type;

        //set ID for every object with its properties
        this.ID = new StringBuilder("PENCIL-" + name + "-" + type.toString() + "-" + country);

        ModelData.getProducts().add(this);

        this.category = ProductCategory.PENCIL;

        ModelData.getPencils().add(this);
    }

    //==============================================================
    public PencilType getType() {
        return type;
    }
//==============================================================

    public void setType(PencilType type) {
        this.type = type;
    }
//==============================================================

    @Override
    public double getPrice() {
        return getPriceWithDiscount();
    }
//==============================================================

    @Override
    public double getPriceWithDiscount() {
        return this.price - (this.price * ((double) discountPercent / 100));
    }
//==============================================================

    @Override
    public void setDiscountPercent(int percent) {
        discountPercent = percent;
    }

    @Override
    public String toString() {
        return "\nPencil{" +
                "\ntype=" + type +
                "\nID=" + ID +
                "\nname='" + name + '\'' +
                "\nprice=" + price +
                "\nnumberOfAvailable=" + numberOfAvailable +
                "\nBuyers score=" + this.getAverageScore() +
                "\nnumber=" + number +
                "}\n\n";
    }
}
