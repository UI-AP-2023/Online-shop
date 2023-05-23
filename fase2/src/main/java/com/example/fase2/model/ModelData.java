package com.example.fase2.model;

import com.example.fase2.model.invoice_comment_score.Comment;
import com.example.fase2.model.product.*;
import com.example.fase2.model.requests.IncrementBalanceRequest;
import com.example.fase2.model.requests.SignupRequest;
import com.example.fase2.model.userAccount.*;

import java.util.ArrayList;

public abstract class ModelData {

    private static final ArrayList<Buyer> customers = new ArrayList<>();

    //private static ArrayList<Comment> rejectedComments = new ArrayList<>();

    //---------------------------------------------------------

    private static final ArrayList<Product> products = new ArrayList<>();

    //-------------------------------------------------------

    private static final ArrayList<Comment> commentsAwaiting = new ArrayList<>();

    //-----------------------------------------------------

    private static final ArrayList<IncrementBalanceRequest> incrementBalanceRequests  = new ArrayList<>();

    //--------------------------------------------------------------

    private static final ArrayList<SignupRequest> signupRequests = new ArrayList<>();

    //----------------------------------------------------------------------
    /**
     * The only admin the shop has
     */
    private static final Admin admin = Admin.getAdmin("admin", "admin41148@gmail.com", "09375509788" , "admin");

    //-------------------------------------------------------

    private static Buyer you = new Buyer("","","","");

    //------------------------------------------------------

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

    //---------------------------------------------------------

    public static void addCommentRequest(Comment comment) {
        commentsAwaiting.add(comment);
    }

    //------------------------------------------------------------------------

    public static Buyer getYou() {
        return you;
    }

    //--------------------------------------------------------------------


    public static void setYou(Buyer you) {
        ModelData.you = you;
    }

    //--------------------------------------------------------------------


    public static ArrayList<IncrementBalanceRequest> getIncrementBalanceRequests() {
        return incrementBalanceRequests;
    }

    //--------------------------------------------------------------------

    public static ArrayList<SignupRequest> getSignupRequests() {
        return signupRequests;
    }

    //----------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------




}
