package view.BuyerView;

import controller.BuyerController;
import controller.LoginPageController;

import java.util.Scanner;

import static view.LoginPageView.scanner;

public interface BuyerView {

    static void showBuyerOptions() {

        Scanner scanner = new Scanner(System.in);
        print("1. PRODUCTS PAGE");
        print("2. MY PROFILE");

        int order = scanner.nextInt();

        scanner.nextLine();

        switch (order) {

            case 1->{}

            case 2 -> showBuyerMainMenu();
        }
    }

    //=================================================================================

    static void showBuyerMainMenu() {
        print("1.SHOW MY PROFILE");
        print("2.EDIT MY PROFILE");
        print("3.INCREMENT BALANCE");
        print("4.SHOW MY BUYING CART");
        print("5.SHOW MY INVOICES");
        print("6.EXIT");

        Scanner scanner = new Scanner(System.in);
        int order = scanner.nextInt();
        scanner.nextLine();

        switch (order) {

            case 1 -> showMyProfile();

            case 2 -> {
            }

            case 3 -> {
            }

            case 4 -> {
            }

            case 5 -> {
            }

            case 6 -> {
            }
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

            case 3 -> {}

            case 4 ->{}

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
