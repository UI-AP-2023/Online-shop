package com.example.fase2.model.product;

import java.util.ArrayList;
import com.example.fase2.model.invoice_comment_score.Comment;

public abstract class Product {

    protected StringBuilder ID;
    protected String name;
    protected double price;
    protected int numberOfAvailable;
    protected ArrayList<Integer> buyersScores = new ArrayList<>();
    protected ProductCategory category;
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
        return buyersScores;
    }

    //---------------------------------------------------

    public int getNumber(){
        return this.number;
    }

    //---------------------------------------------

    public double getPrice(){
        return this.price;
    }
    //---------------------------------------------

    public ProductCategory getCategory() {
        return this.category;
    }
    //---------------------------------------------

    public int getAvailable() {
        return numberOfAvailable;
    }

    public void setID(StringBuilder ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumberOfAvailable(int numberOfAvailable) {
        this.numberOfAvailable = numberOfAvailable;
    }

}