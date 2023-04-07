package model.product;

import model.invoice_comment_score.Comment;

import java.util.ArrayList;

public abstract class Product {

    protected StringBuilder ID;
    protected String name;
    protected double price;
    protected int numberOfAvailable;
    protected ArrayList<Integer> buyersScores = new ArrayList<>();
    protected static ProductCategory category;
    private static int staticNumber=1;
    protected int number;
    public ArrayList<Comment> comments = new ArrayList<>();

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
        return number + " . " + name + "\n" + price + "$" + "\nAVAILABLE: "+ numberOfAvailable;
    }

    //-------------------------------------------------------------------------------------

    public void AddComment(Comment comment) {
        comments.add(comment);
    }

    //--------------------------------------------------------------------------------------

    public ArrayList<Integer> getBuyersScores() {
        return new ArrayList<>(buyersScores);
    }

    //---------------------------------------------------

    public int getNumber(){
        return this.number;
    }

    //---------------------------------------------

    public double getPrice(){
        return this.price;
    }

}