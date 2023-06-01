package com.example.phase2.model.product;

import java.util.ArrayList;
import java.util.Collection;

import com.example.phase2.model.invoice_comment_score.Comment;

public class Product implements Comparable<Product> {

    protected StringBuilder ID;
    protected String name;
    protected double price;
    protected int numberOfAvailable;
    protected ArrayList<Integer> buyersScores = new ArrayList<>();
    protected ProductCategory category;
    private static int staticNumber = 1;
    protected int number;
    public ArrayList<Comment> comments = new ArrayList<>();

    //======================================================================================

    protected Product(String name, int numberOfAvailable, double price) {

        this.name = name;
        this.price = price;
        this.numberOfAvailable = numberOfAvailable;

        this.number = staticNumber;
        staticNumber++;
    }

    //-------------------------------------------------------------------------------------

    public String getID() {
        return ID.toString();
    }

    //-------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return number + " . " + name + "\n" + price + "$" + "\nAVAILABLE: " + numberOfAvailable;
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

    public int getNumber() {
        return this.number;
    }

    //---------------------------------------------

    public double getPrice() {
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
    //---------------------------------------------

    public void setID(StringBuilder ID) {
        this.ID = ID;
    }
    //---------------------------------------------

    public void setName(String name) {
        this.name = name;
    }
    //---------------------------------------------

    public void setPrice(double price) {
        this.price = price;
    }
    //---------------------------------------------

    public void setNumberOfAvailable(int numberOfAvailable) {
        this.numberOfAvailable = numberOfAvailable;
    }
    //---------------------------------------------

    public Collection<Comment> getComments() {
        return comments;
    }
    //---------------------------------------------

    public double getAverageScore() {
        double sum = 0;
        for (int i : buyersScores) {
            sum += i;
        }
        return sum / buyersScores.size();
    }

    //---------------------------------------------

    @Override
    public int compareTo(Product that) {


        if (this.name.compareTo(that.name) != 0) return this.name.compareTo(that.name);
//////////////
        else if (this.getAverageScore() > that.getAverageScore())
            return 1;
        else if (this.getAverageScore() < that.getAverageScore())
            return -1;
//////////////
        else if(this.price < that.price)
            return 1;
        else if (this.price > that.price) 
            return -1;
//////////////
        else return Integer.compare(this.numberOfAvailable, that.numberOfAvailable);

    }
}