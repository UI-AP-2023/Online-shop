package Model.User_account;

import Model.Product.Product;

import java.util.ArrayList;

public class Admin extends Account{

    private static Admin admin;

    ArrayList<Model.Product.Product> products = new ArrayList<>();
    //    ArrayList<BuyingREQUEST>
    //    ArrayList<SignupRequest>


    private Admin(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
    }

    //())))))))))))))))))))))))))))))))))SINGLETON

    static Admin GetAdmin(String userName, String email, String phoneNumber, String password){
        if(admin == null){
            admin = new Admin(userName, email, phoneNumber, password);
        }
        return admin;
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
