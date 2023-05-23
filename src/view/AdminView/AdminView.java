package view.AdminView;

import java.util.Scanner;

public interface AdminView {

//-------------------------------------------------------------------------------------------------
    static void AdminShowOptions() {

        System.out.println(" PLEASE ENTER THE COMMAND (...ALL LETTERS SHOULD BE CAPITAL...) HELP FOR COMMANDS GUID\n");

        Scanner scanner = new Scanner(System.in);

        String order = scanner.next();

        switch (order) {

            case "ADD" :{}

            case "EDIT" :{}

            case "REMOVE" :{}

            case "SIGNUP" :{}

            case "BALANCE" :{}

            case "EXIT" : {}

            case "HELP" :{

                System.out.println("ADD: add a product to the shop(you should write product properties after 'ADD')\n");
                System.out.println("EDIT: edit a product's properties that exist in the shop (you should write the product's new properties after 'EDIT')\n");
                System.out.println("REMOVE: remove a product from the shop\n");
                System.out.println("SIGNUP: show sign up requests\n");
                System.out.println("BALANCE: show balance increase requests\n");
                System.out.println("Exit: for exit :/\n");
            }

        }
    }
}
