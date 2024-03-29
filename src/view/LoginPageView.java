package view;

import controller.BuyerController;
import controller.LoginPageController;
import model.ModelData;
import model.requests.SignupRequest;
import model.userAccount.Buyer;

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

        LoginPageController.loginCheck(UserName, Password);
    }


    //====================================================================

    static void signupView() {

        System.out.println("\nUSER NAME: ");

        String userName, password = null, email=null, phone=null;

        while (true) {
            userName = scanner.nextLine();

            if (BuyerController.checkUserName(userName)) {

                BuyerController.setUserName(userName);
                break;

            } else
                System.out.println("\nTHIS USER NAME IS ALREADY EXIST , TRY ANOTHER ONE: ");
        }

        //---------------------------------------------------------------------------------------------PASSWORD

        System.out.println("PASSWORD(4 letters at least and it should has 1 uppercase character , 1 lowercase and 1 number at least): ");
        /*
          get password till when its valid
         */
        boolean passwordChecked = false;
        while (!passwordChecked) {
            password = scanner.nextLine();

            if (!LoginPageController.passwordCheck(password)) {
                System.out.println("PASSWORD IS NOT VALID, ENTER ANOTHER ONE");
            } else {
                passwordChecked = true;
            }
        }

        //------------------------------------------------------------------------------------------------EMAIL
        System.out.println("EMAIL: ");

        boolean emailChecked = false;
        while (!emailChecked) {
            email = scanner.nextLine();

            if (!LoginPageController.emailCheck(email)) {
                System.out.println("EMAIL IS NOT VALID, ENTER ANOTHER ONE");
            } else {
                emailChecked = true;
            }
        }

        //-----------------------------------------------------------------------------------------------Phone Number
        System.out.println("PHONE NUMBER: ");

        boolean phoneNumberChecked = false;
        while (!phoneNumberChecked) {

            phone = scanner.nextLine();

            if (!LoginPageController.phoneNumberCheck(phone)) {
                System.out.println("PHONE NUMBER IS NOT VALID, ENTER ANOTHER ONE");
            } else {
                phoneNumberChecked = true;
            }
        }


        Buyer requester = new Buyer(userName, password, phone, email);
        SignupRequest request = new SignupRequest(requester);

        LoginPageController.setSignupRequest(request);

        System.out.println("...YOUR SIGN UP REQUEST SENT FOR ADMIN...\n");

        showLoginPage();
    }

    //===================================================================

    static void notFoundView() {

        System.out.println("\nYOUR USER NAME OR PASSWORD IS NOT CORRECT\n");

        showLoginPage();
    }

    //======================================================================

    static void invalidParametersView() {
        System.out.println("\n...YOUR EMAIL OR PHONE NUMBER OR YOUR PASSWORD IS NOT VALID FOR SIGNING UP...\nPLEASE TRY AGAIN\n");
        signupView();
    }
}
