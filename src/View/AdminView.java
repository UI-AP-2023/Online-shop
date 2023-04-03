package View;

import java.util.Scanner;

public interface AdminView {

    static void ShowOptions() {

        System.out.println(" PLEASE ENTER THE COMMAND (...ALL LETTERS SHOULD BE CAPITAL...)\n\n");

        Scanner scanner = new Scanner(System.in);

        String order = scanner.next();

        switch (order) {
            case "ADD" :{}
            case "EDIT" :{}
            case "REMOVE" :{}
            case "SIGNUP_REQUESTS" :{}
            case "BUYING_REQUEST" :{}
        }
    }
}
