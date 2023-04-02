package Model.Product;

public abstract class Product {

    protected StringBuilder ID;
    protected String name;
    protected double price;
    protected int numberOfAvailable;
    protected double buyersAverageScore;
    protected static ProductCategory category;
    //==========================constructor must be added

    protected Product(String name, int numberOfAvailable, double price){
        this.name = name;
        this.price = price;
        this.numberOfAvailable = numberOfAvailable;
    }

    public String getID() {
        return ID.toString();
    }
}

// enum Category{ ---------------------------------=================

