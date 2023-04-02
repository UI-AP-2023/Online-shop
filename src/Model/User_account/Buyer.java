package Model.User_account;

import Model.Product.Product;
import java.util.ArrayList;


public class Buyer extends Account{

        ArrayList<Product> ProductsCart = new ArrayList<>();
    //    ArrayList<Factor>

    private double balance;

    Buyer(String userName, String email, String phoneNumber, String password) {
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

    //----------------------------------------------

    public void IncreaseBalance(double cash){
        this.balance += cash;
    }

    //-----------------------------------------------

    public void DecreaseBalance(double cash){
        this.balance -= cash;
    }

    //--------------------------------------------------

    @Override
    public String toString(){
        return "USER NAME: "+userName + ", EMAIL: " + email;
    }
}
