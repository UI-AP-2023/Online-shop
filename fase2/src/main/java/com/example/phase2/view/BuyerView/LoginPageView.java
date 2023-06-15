package com.example.phase2.view.BuyerView;

import com.example.fase2.exceptions.InvalidLoginException;
import com.example.fase2.exceptions.ThisIsCustomer;
import com.example.phase2.controller.BuyerController;
import com.example.phase2.controller.LoginPageController;
import com.example.phase2.exceptions.InUsedUserNameException;
import com.example.phase2.exceptions.InvalidEmailException;
import com.example.phase2.exceptions.InvalidPasswordException;
import com.example.phase2.exceptions.InvalidPhoneNumberException;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.userAccount.Buyer;
import java.util.Scanner;

public interface LoginPageView {

    Scanner scanner = new Scanner(System.in);

    static void showLoginPage() {

        System.out.println("1.Log in\n2.Sign up");

        int LoginOrder = scanner.nextInt();
        scanner.nextLine();

        switch (LoginOrder) {

            case 1 -> loginView();

            case 2 -> signupView();
        }
    }

    //====================================================================

    static void loginView() {

        System.out.println("USER NAME: ");
        String UserName = scanner.nextLine();
        System.out.println("PASSWORD: ");
        String Password = scanner.nextLine();

        try {
            LoginPageController.loginCheck(UserName, Password);
        } catch (InvalidLoginException e) {

            System.out.println("Invalid information");

            showLoginPage();
        }
    }



    //====================================================================

    static void signupView() {

        System.out.println("\nUSER NAME: ");

        String userName = null, password = null, email = null, phone = null;

        boolean usernameChecked = false;
        //---------------------------------------------------------------------------------------------Username

        while (!usernameChecked) {

            userName = scanner.next();

            try {

                BuyerController.checkUserName(userName);
                usernameChecked = true;

            } catch (InUsedUserNameException e) {
                System.out.println("\nTHIS USER NAME IS ALREADY EXIST , TRY ANOTHER ONE: ");
            }
        }

        //---------------------------------------------------------------------------------------------PASSWORD

        System.out.println("PASSWORD(4 letters at least and it should has 1 uppercase character , 1 lowercase and 1 number at least): ");
        /*
         * get password till when its valid
         */
        boolean passwordChecked = false;
        while (!passwordChecked) {
            password = scanner.nextLine();

            try {
                LoginPageController.passwordCheck(password);
                passwordChecked = true;
            } catch (InvalidPasswordException e) {
                System.out.println("PASSWORD IS NOT VALID, ENTER ANOTHER ONE");
            }
        }

        //------------------------------------------------------------------------------------------------EMAIL
        System.out.println("EMAIL: ");

        boolean emailChecked = false;

        while (!emailChecked) {

            email = scanner.nextLine();

            try {

                LoginPageController.emailCheck(email);
                emailChecked = true;

            } catch (InvalidEmailException e) {
                System.out.println("EMAIL IS NOT VALID, ENTER ANOTHER ONE");
            }
        }

        //-----------------------------------------------------------------------------------------------Phone Number
        System.out.println("PHONE NUMBER: ");

        boolean phoneNumberChecked = false;

        while (!phoneNumberChecked) {

            phone = scanner.nextLine();

            try {

                LoginPageController.phoneNumberCheck(phone);
                phoneNumberChecked = true;

            } catch (InvalidPhoneNumberException e) {
                System.out.println("PHONE NUMBER IS NOT VALID, ENTER ANOTHER ONE");
            }
        }

        ModelData.addCustomer(new Buyer(userName, password, phone, email));

        System.out.println("...YOU ARE SIGNED IN SUCCESSFULLY...\n");

        showLoginPage();
    }

    //===================================================================

    static void notFoundView() throws InvalidLoginException {

        System.out.println("\nYOUR USER NAME OR PASSWORD IS NOT CORRECT\n");

        showLoginPage();
    }

    //======================================================================
}
