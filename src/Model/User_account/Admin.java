package Model.User_account;

import Model.Product.Product;

import java.util.ArrayList;

public class Admin extends Account{


    ArrayList<Model.Product.Product> products = new ArrayList<>();
    //    ArrayList<BuyingREQUEST>
    //    ArrayList<SignupRequest>


    Admin(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
    }

    //-------------------------------------------------------
    void AddProduct(Product product) {
        products.add(product);
    }
    //-------------------------------------------------------

    // void AddBuyingRequest

    //-------------------------------------------------

    //void AddSignupRequest
}
