package com.example.fase2.model.userAccount;


import com.example.fase2.model.invoice_comment_score.Invoice;
import com.example.fase2.model.product.Product;

import java.util.ArrayList;

public class Buyer extends Account{

    private final ArrayList<Product> ProductsCart = new ArrayList<>();
    private final ArrayList<Invoice> invoices = new ArrayList<>();

    private double balance;

    public Buyer(String userName, String password, String phoneNumber, String email) {
        super(userName, email, phoneNumber, password);
    }

    //-------------------------------------------------

    public double getBalance() {
        return balance;
    }

    //--------------------------------------------------

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //--------------------------------------------------

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    //--------------------------------------------------
    @Override
    public String toString(){
        return "USER NAME: (" + userName + ") , PASSWORD: (" + password + "), EMAIL: (" + email + ") , PHONE NUMBER: " + phoneNumber;
    }

    //--------------------------------------------------

    public ArrayList<Product> getProductsCart() {
        return ProductsCart;
    }

    //--------------------------------------------------

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    //------------------------------------------------------

    public void addProduct(Product product) {
        ProductsCart.add(product);
    }

    //--------------------------------------------

}
