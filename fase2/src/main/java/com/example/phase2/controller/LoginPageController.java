package com.example.phase2.controller;

import com.example.fase2.exceptions.InvalidLoginException;
import com.example.fase2.exceptions.ThisIsCustomer;
import com.example.phase2.exceptions.InvalidEmailException;
import com.example.phase2.exceptions.InvalidPasswordException;
import com.example.phase2.exceptions.InvalidPhoneNumberException;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.userAccount.Buyer;
import com.example.phase2.view.AdminView.AdminView;
import com.example.phase2.view.BuyerView.BuyerView;
import com.example.phase2.view.BuyerView.LoginPageView;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface LoginPageController {


    //-------------------------------------------------------------------------------------------------------------

    /**
     * check username and password for customers  if the user is a customer it calls buyers view
     * else if its admin , calls admin view
     */
    static void loginCheck(String username, String password) throws InvalidLoginException {

        // if  customer

        for (Buyer buyer : ModelData.getCustomers()) {

            if (Objects.equals(buyer.getUserName(), username) && Objects.equals(buyer.getPassword(), password)) {

                // to know who is using the program
                ModelData.setYou(buyer);

                BuyerView.showBuyerMainMenu();

                break;
            }
        }

        //if s/he is admin
        if (Objects.equals(ModelData.getAdmin().getUserName(), username) && Objects.equals(ModelData.getAdmin().getPassword(), password)) {

            AdminView.AdminShowOptions();
            //--------------------------------
            LoginPageView.showLoginPage();

        } else {
//            LoginPageView.notFoundView();
            throw new InvalidLoginException();
        }
    }

    //=============================================================================================================

    static void emailCheck(String email) throws InvalidEmailException {

        Pattern emailPattern = Pattern.compile("^\\w+@\\D+\\.(org|com)");
        Matcher emailMatcher = emailPattern.matcher(email);

        if (!emailMatcher.find()) throw new InvalidEmailException();
    }

    //=================================================================================================================

    static void phoneNumberCheck(String phone) throws InvalidPhoneNumberException {

        Pattern phoneNumberPattern = Pattern.compile("^0\\d{10}$");
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phone);
        if (!phoneNumberMatcher.find()) throw new InvalidPhoneNumberException();
    }

    //=================================================================================================================

    static void passwordCheck(String password) throws InvalidPasswordException {
        Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#~`\\-_$%^&*+=])[a-zA-z\\d!@#~`\\-_$%^&*+=]{4,}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if(!passwordMatcher.find()) throw new InvalidPasswordException();
    }

    //====================================================================================================

    //==================================================================================================

    //==================================================================================================

    //==================================================================================================



}
