package view;

import controller.LoginPageController;

import java.util.Scanner;

public interface LoginPageView {

    Scanner scanner = new Scanner(System.in);

    static void ShowLoginPage() {

        System.out.println("1.Log in\n2.Sign up");

        int LoginOrder = scanner.nextInt();

        switch (LoginOrder){

            case 1:{LoginView();}

            case 2:{SignupView();}
        }
    }

    //====================================================================

    static void LoginView(){

        System.out.println("USER NAME: ");
        String UserName = scanner.nextLine();
        System.out.println("PASSWORD: ");
        String Password = scanner.nextLine();

        LoginPageController.LoginCheck(UserName, Password);
    }


    //====================================================================

    static void SignupView() {

        System.out.println("\nUSER NAME: ");
        String userName = scanner.nextLine();
        System.out.println("PASSWORD(4 letters at least and it should has 1 uppercase character , 1 lowercase and 1 number at least): ");
        String password = scanner.nextLine();
        System.out.println("EMAIL: ");
        String email = scanner.nextLine();
        System.out.println("PHONE NUMBER: ");
        String phone = scanner.nextLine();
        System.out.println();// just an end line

        // controller sign up
        LoginPageController.SignupCheck(userName, password, email, phone);
    }

    //===================================================================

    static void NotFoundView() {

        System.out.println("\nYOUR USER NAME OR PASSWORD IS NOT CORRECT\n");

        ShowLoginPage();
    }

    //======================================================================

    static void InvalidParametersView(){
        System.out.println("\n...YOUR EMAIL OR PHONE NUMBER OR YOUR PASSWORD IS NOT VALID FOR SIGNING UP...\nPLEASE TRY AGAIN\n");
        SignupView();
    }
}
