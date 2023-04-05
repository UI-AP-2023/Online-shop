package controller;

import model.ModelData;
import model.userAccount.Buyer;
import view.AdminView.AdminView;
import view.BuyerView.BuyerView;
import view.LoginPageView;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface LoginPageController {


    //-------------------------------------------------------------------------------------------------------------

    /**
     * check username and password for customers  if the user is a customer it calls buyers view
     * else if its admin , calls admin view
     */
    static void LoginCheck(String username, String password) {

        // if  customer
        for (Buyer buyer : ModelData.getCustomers()) {
            if (Objects.equals(buyer.getUserName(), username) && Objects.equals(buyer.getPassword(), password)) {
                BuyerView.ShowBuyerOptions();
                break;
            }
        }

        //if s/he is admin
        if (Objects.equals(ModelData.getAdmin().getUserName(), username) && Objects.equals(ModelData.getAdmin().getPassword(), password)) {
            AdminView.AdminShowOptions();
        } else {
            LoginPageView.NotFoundView();
        }
    }

    //=============================================================================================================

    static void SignupCheck(String username, String password, String email, String phone) {

        boolean emailVerified = false;
        boolean passwordVerified = false;
        boolean phoneVerified = false;

        //-----------------------------------------------------------------------------email
        Pattern emailPattern = Pattern.compile("^\\D\\w+@\\D+\\.(org|com)");
        Matcher emailMatcher = emailPattern.matcher(email);
        if (emailMatcher.find()) {
            emailVerified = true;
        }
        //---------------------------------------------------------------------------------password

        Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#~`\\-_$%^&*+=])[a-zA-z\\d!@#~`\\-_$%^&*+=]{4,}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (passwordMatcher.find()) {
            passwordVerified = true;
        }
        //--------------------------------------------------------------------------------------

        Pattern phoneNumberPattern = Pattern.compile("^\\d{11}$");
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phone);
        if (phoneNumberMatcher.find()) {
            phoneVerified = true;
        }

        if(emailVerified && passwordVerified && phoneVerified){
            SignupController(username, password, phone, email);
        }else {
            LoginPageView.InvalidParametersView();
        }

    }


    //====================================================================================================

    static void SignupController(String username, String password, String phone , String email) {

        Buyer temp = new Buyer(username, password, phone, email);

        ModelData.addCustomer(temp);


    }
}
