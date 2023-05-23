package model.product.digital_Product;

import model.product.Product;
import model.product.ProductCategory;

public abstract class DigitalProduct extends Product {

    private double weight;
    private double size;
    //0000000000000000000000000000000000000000000000000===constructor

    protected DigitalProduct(int weight, int size, String name , int numberOfAvailable,double price) {
        super(name, numberOfAvailable,price);
        this.weight = weight;
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}




