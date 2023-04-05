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

        System.out.println("USER NAME: ");
        String userName = scanner.nextLine();
        System.out.println("PASSWORD: ");
        String password = scanner.nextLine();
        System.out.println("EMAIL: ");
        String email = scanner.nextLine();
        System.out.println("PHONE NUMBER: ");
        String phone = scanner.nextLine();

        // controller sign up
    }


}
