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

    static boolean EmailCheck (String email) {

        Pattern emailPattern = Pattern.compile("^\\w+@\\D+\\.(org|com)");
        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.find();
    }

    //=================================================================================================================

    static boolean PhoneNumberCheck(String phone) {

        Pattern phoneNumberPattern = Pattern.compile("^0\\d{10}$");
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phone);
        return phoneNumberMatcher.find();
    }

    //=================================================================================================================

    static boolean PasswordCheck(String password){
        Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#~`\\-_$%^&*+=])[a-zA-z\\d!@#~`\\-_$%^&*+=]{4,}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        return passwordMatcher.find();
    }

    //====================================================================================================

    static void SignupController(String username, String password, String phone , String email) {

        Buyer temp = new Buyer(username, password, phone, email);

        ModelData.addCustomer(temp);


    }
}
