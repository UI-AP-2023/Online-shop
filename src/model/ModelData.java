package model;

import model.product.Product;
import model.userAccount.Admin;
import model.userAccount.Buyer;
import javax.xml.stream.events.Comment;
import java.util.ArrayList;

public abstract class ModelData {

    private static final ArrayList<Buyer> customers = new ArrayList<>();

    //private static ArrayList<Comment> rejectedComments = new ArrayList<>();

    //---------------------------------------------------------

    private static final ArrayList<Product> products = new ArrayList<>();

    //-------------------------------------------------------

    private static final ArrayList<Comment> commentsAwaiting = new ArrayList<>();

    //-----------------------------------------------------
    /**
     * The only admin the shop has
     */
    private static final Admin admin = Admin.getAdmin("admin", "admin41148@gmail.com", "09375509788" , "admin");

    //-------------------------------------------------------

    public static ArrayList<Buyer> getCustomers() {
        return customers;
    }

    //------------------------------------------------------------

    public static ArrayList<Product> getProducts() {
        return products;
    }

    //--------------------------------------------------------------

    public static ArrayList<Comment> getCommentsAwaiting() {
        return commentsAwaiting;
    }

    //-------------------------------------------------------

    public static Admin getAdmin() {
        return admin;
    }

    //--------------------------------------------------------

    public static void addCustomer(Buyer customer) {
        customers.add(customer);
    }

    //--------------------------------------------------------

    public static void addProduct(Product product) {
        products.add(product);
    }

    //---------------------------------------------------------

    public static void addCommentRequest(Comment comment) {
        commentsAwaiting.add(comment);
    }

    //----------------------------------------------------------

}