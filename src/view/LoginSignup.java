package view;

import java.util.Scanner;

public interface LoginSignup {

    static void ShowLoginPage() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1.Log in\n2.Sign up");

        int LoginOrder = scanner.nextInt();

        switch (LoginOrder){

            case 1:{}//Login

            case 2:{}//Sign up
        }
    }


    static void Login(){

    }

}
