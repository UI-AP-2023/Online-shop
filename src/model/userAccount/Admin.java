package model.userAccount;

import model.product.Product;
import model.requests.SignupRequest;

import java.util.ArrayList;

public class Admin extends Account{

    private static Admin admin;

    ArrayList<model.product.Product> products = new ArrayList<>();

    //    ArrayList<CommentRequest>

    ArrayList<SignupRequest> signupRequests = new ArrayList<>();


    private Admin(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
    }

    //(((((((((((((((((((((((((((((((((...SINGLETON...))))))))))))))))))))))))))))))))))

    public static Admin getAdmin(String userName, String email, String phoneNumber, String password){
        if(admin == null){
            admin = new Admin(userName, email, phoneNumber, password);
        }
        return admin;
    }

    //-------------------------------------------------------

    void AddProduct(Product product) {
        products.add(product);
    }

    //-------------------------------------------------

    // add comment request

    //--------------------------------------------------
    public void AddSignupRequest(SignupRequest request){
        signupRequests.add(request);
    }
}
