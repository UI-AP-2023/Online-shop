package model.userAccount;

import model.invoice_comment_score.Invoice;
import model.product.Product;
import java.util.ArrayList;


public class Buyer extends Account{

    ArrayList<Product> boughtProducts = new ArrayList<>();
    ArrayList<Product> ProductsCart = new ArrayList<>();
    ArrayList<Invoice> invoices = new ArrayList<>();

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

    public void addBoughtProduct(Product product) {
        boughtProducts.add(product);
    }

    //--------------------------------------------------
    @Override
    public String toString(){
        return "USER NAME: "+userName + ", EMAIL: " + email;
    }
}
