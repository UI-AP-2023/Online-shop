package view.BuyerView;

import controller.BuyerController;
import controller.LoginPageController;
import view.LoginPageView;

import java.util.Scanner;

public interface BuyerView {

    static void showBuyerOptions() {

        Scanner scanner = new Scanner(System.in);
        print("1. PRODUCTS PAGE");
        print("2. MY PROFILE");
        print("3. EXIT");

        int order = scanner.nextInt();

        scanner.nextLine();

        switch (order) {

            case 1->{}

            case 2 -> showBuyerMainMenu();

            case 3 -> LoginPageView.showLoginPage();
        }
    }

    //=================================================================================

    static void showBuyerMainMenu() {
        print("1.SHOW MY PROFILE");
        print("2.EDIT MY PROFILE");
        print("3.INCREMENT BALANCE");
        print("4.SHOW MY BUYING CART");
        print("5.SHOW MY INVOICES");

        Scanner scanner = new Scanner(System.in);
        int order = scanner.nextInt();
        scanner.nextLine();

        switch (order) {

            case 1 -> showMyProfile();

            case 2 -> editMyProfile();

            case 3 -> {}

            case 4 -> {}

            case 5 -> {}

        }

    }

    //------------------------------------------------------------------------------------

    static void showMyProfile() {
        print(BuyerController.getMyProfile());
    }

    //--------------------------------------------------------------------------------------

    static void editMyProfile() {
        print("WHICH PROPERTY YOU WANT TO CHANGE? (1.USER NAME)(2.PASSWORD)(3.EMAIL)(4.PHONE NUMBER)\n");

        Scanner scanner = new Scanner(System.in);

        int order = scanner.nextInt();
        scanner.nextLine();

        switch (order) {

            case 1 -> changeUserName();

            case 2 -> changePassword();

            case 3 -> changeEmail();

            case 4 -> changePhoneNumber();

        }
    }

    //-------------------------------------------------------------

    static void changePhoneNumber() {
        print("PLEASE ENTER THE NEW PHONE NUMBER: ");

        Scanner scanner = new Scanner(System.in);
        String phoneNumber;

        while (true) {
            phoneNumber = scanner.nextLine();

            if (LoginPageController.phoneNumberCheck(phoneNumber)) {

                BuyerController.setPhoneNumber(phoneNumber);

                print("\nYOUR LINKED PHONE NUMBER CHANGED SUCCESSFULLY\n");
                break;

            } else
                print("\nTHIS PHONE NUMBER IS NOT VALID , TRY ANOTHER ONE: ");
        }

    }

    //--------------------------------------------------

    static void changeEmail() {

        print("PLEASE ENTER THE NEW EMAIL: ");

        Scanner scanner = new Scanner(System.in);
        String email;

        while (true) {
            email = scanner.nextLine();

            if (LoginPageController.emailCheck(email)) {

                BuyerController.setEmail(email);

                print("\nYOUR EMAIL CHANGED SUCCESSFULLY\n");
                break;

            } else
                print("\nTHIS EMAIL IS NOT VALID , TRY ANOTHER ONE: ");
        }


    }

    //-------------------------

    static void changeUserName() {

        print("\nENTER YOUR NEW USER NAME: ");
        Scanner scanner = new Scanner(System.in);
        String userName;

        while (true) {
            userName = scanner.nextLine();

            if (BuyerController.checkUserName(userName)) {

                BuyerController.setUserName(userName);

                print("\nYOUR USER NAME CHANGED SUCCESSFULLY\n");
                break;

            } else
                print("\nTHIS USER NAME IS ALREADY EXIST , TRY ANOTHER ONE: ");
        }

    }

    //----------------------------------------------------------------------------------

    static void changePassword() {

        print("\nENTER YOUR NEW Password(4 letters at least and it should be made by uppercase, lowercase & special characters & digits ): ");
        Scanner scanner = new Scanner(System.in);
        String password;

        while (true) {
            password = scanner.nextLine();

            if (LoginPageController.passwordCheck(password)) {

                BuyerController.setPassword(password);

                print("\nYOUR PASSWORD CHANGED SUCCESSFULLY\n");
                break;

            } else
                print("\nTHIS PASSWORD IS NOT VALID , TRY ANOTHER ONE: ");
        }


    }

    //--------------------------------------------------------------------------------------

























    //[][][][][][][][][][][][][][][][]][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]][][][]
    static void print(Object obj) {
        System.out.println(obj);
    }
}
