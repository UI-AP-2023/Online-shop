package view;

import controller.LoginPageController;
import model.ModelData;
import model.userAccount.Buyer;

import java.util.Scanner;

public interface LoginPageView {

    Scanner scanner = new Scanner(System.in);

    static void ShowLoginPage() {

        System.out.println("1.Log in\n2.Sign up");

        int LoginOrder = scanner.nextInt();

        switch (LoginOrder) {

            case 1: {
                LoginView();
            }

            case 2: {
                SignupView();
            }
        }
    }

    //====================================================================

    static void LoginView() {

        System.out.println("USER NAME: ");
        String UserName = scanner.nextLine();
        System.out.println("PASSWORD: ");
        String Password = scanner.nextLine();

        LoginPageController.LoginCheck(UserName, Password);
    }


    //====================================================================

    static void SignupView() {

        System.out.println("\nUSER NAME: ");

        String userName, password = null, email=null, phone=null;

        while (true) {

            boolean userNameCheck = true;
            userName = scanner.nextLine();

            for (Buyer customer : ModelData.getCustomers()) {

                if (customer.getUserName().equals(userName)) {
                    System.out.println("THIS USER NAME IS  ALREADY EXIST , TRY AGAIN: ");
                    userNameCheck = false;
                    break;
                }
            }

            if(userNameCheck)
                break;
        }

        //---------------------------------------------------------------------------------------------PASSWORD

        System.out.println("PASSWORD(4 letters at least and it should has 1 uppercase character , 1 lowercase and 1 number at least): ");
        /*
          get password till when its valid
         */
        boolean passwordChecked = false;
        while (!passwordChecked) {
            password = scanner.nextLine();

            if (!LoginPageController.PasswordCheck(password)) {
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

            if (!LoginPageController.EmailCheck(email)) {
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

            if (!LoginPageController.PhoneNumberCheck(phone)) {
                System.out.println("EMAIL IS NOT VALID, ENTER ANOTHER ONE");
            } else {
                phoneNumberChecked = true;
            }
        }

        LoginPageController.SignupController(userName, password, phone, email);

        System.out.println("...YOU SIGNED UP SUCCESSFULLY...\n");
    }

    //===================================================================

    static void NotFoundView() {

        System.out.println("\nYOUR USER NAME OR PASSWORD IS NOT CORRECT\n");

        ShowLoginPage();
    }

    //======================================================================

    static void InvalidParametersView() {
        System.out.println("\n...YOUR EMAIL OR PHONE NUMBER OR YOUR PASSWORD IS NOT VALID FOR SIGNING UP...\nPLEASE TRY AGAIN\n");
        SignupView();
    }
}
