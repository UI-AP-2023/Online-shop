package Model.Product;

import java.util.ArrayList;

public abstract class Product {

    protected StringBuilder ID;
    protected String name;
    protected double price;
    protected int numberOfAvailable;
    protected double buyersAverageScore;
    protected static ProductCategory category;
    private static int staticNumber=1;
    protected int number;
    public ArrayList<String> comments = new ArrayList<>();

    //======================================================================================

    protected Product(String name, int numberOfAvailable, double price){

        this.name = name;
        this.price = price;
        this.numberOfAvailable = numberOfAvailable;

        this.number=staticNumber;
        staticNumber++;
    }

    //-------------------------------------------------------------------------------------

    public String getID() {
        return ID.toString();
    }

    //-------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return number + " . " + name + "\n" + price + "$";
    }
}