package view.BuyerView;

import java.util.Scanner;

public interface BuyerView {

    static void showBuyerOptions() {

        print("1. PRODUCTS PAGE");
        print("2. MY PROFILE");

        Scanner scanner = new Scanner(System.in);
        int order = scanner.nextInt();

        scanner.nextLine();

        switch (order) {

            case 1:

            case 2:
        }
    }

    //=================================================================================

    static void showMyProfile(){
        print("1.SHOW MY PROPERTIES");
        print("2.EDIT MY PROFILE");
        print("3.INCREMENT BALANCE");
        print("4.SHOW MY BUYING CART");
        print("5.SHOW MY INVOICES");
    }

















    //[][][][][][][][][][][][][][][][]][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]][][][]
    static void print(Object obj) {
        System.out.println(obj);
    }
}
