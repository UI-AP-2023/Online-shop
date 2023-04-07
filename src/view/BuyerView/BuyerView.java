package view.BuyerView;

import controller.BuyerController;
import controller.LoginPageController;
import model.invoice_comment_score.Invoice;
import model.product.Product;
import view.LoginPageView;

import java.util.Scanner;

import static view.LoginPageView.scanner;

public interface BuyerView {

    static void showBuyerMainMenu() {

        Scanner scanner = new Scanner(System.in);
        print("\n1. PRODUCTS PAGE");
        print("2. MY PROFILE");
        print("3. EXIT\n");

        int order = scanner.nextInt();

        scanner.nextLine();

        switch (order) {

            case 1 -> showProductsPageOptions();

            case 2 -> showBuyerProfileOptions();

            case 3 -> LoginPageView.showLoginPage();
        }
    }

    //---------------------------------------------------------------------------------

    static void showProductsPageOptions() {
        print("\n1. SHOW ALL OF PRODUCTS IN THE SHOP");
        print("2. USE FILTER FOR SHOWING PRODUCTS");
        print("3. RETURN TO PREVIOUS PAGE\n");

        Scanner scanner = new Scanner(System.in);
        int order = scanner.nextInt();

        switch (order) {

            case 1 -> showAllProducts();

            case 2 -> {
            }

            case 3 -> showBuyerMainMenu();
        }

    }

    //--------------------------------------------------

    static void showAllProducts() {

        for (Product product : BuyerController.getProducts()) {
            print(product.toString());
        }

        enterProductsPageNumber();
    }

    static void enterProductsPageNumber() {
        print("\nENTER \"0\" FOR PREVIOUS PAGE OR ENTER YOUR PRODUCT NUMBER");

        int numberOfProduct = 1000;

        while (numberOfProduct != 0) {
            Scanner scanner = new Scanner(System.in);
            numberOfProduct = scanner.nextInt();

            if (numberOfProduct > 0) {
                showProduct(numberOfProduct);
            } else if (numberOfProduct == 0) {
                showProductsPageOptions();
            } else {
                print("THE NUMBER YOU ENTERED IS UNAFFECTED, ENTER ANOTHER ONE:\n");
            }
        }
    }

    static void showProduct(int numberOfProduct) {

        if (BuyerController.getThisProduct(numberOfProduct) != null) {

            print(BuyerController.getThisProduct(numberOfProduct));

            BuyerView.showThisProductOptions(BuyerController.getThisProduct(numberOfProduct));

        } else {
            print("\nTHE NUMBER YOU ENTERED IS NOT FOR ANY PRODUCT,PLEASE ENTER ANOTHER ONE");
            enterProductsPageNumber();
        }
    }

    //-------------------------------------------
    static void showThisProductOptions(Product product) {

        print("1.Add to the cart");
        print("2.Comments");
        print("3.Rating");
        print("4.Previous page");


        Scanner scanner = new Scanner(System.in);
        int order = scanner.nextInt();

        switch (order) {

            case 1 -> buyThisProduct(product);

            case 2 -> addComments(product);

            case 3 ->{}

            case 4-> showAllProducts();
        }
    }

    //------------------------------------------------

    static void addComments(Product product) {

        print("Write here:");

        Scanner scanner = new Scanner(System.in);
        String commentText = scanner.nextLine();

        BuyerController.addComment(commentText, product);

        print("COMMENT REQUEST SENT");

        showProduct(product.getNumber());
    }

    //------------------------------------------
    static void buyThisProduct(Product product) {

        Scanner scanner = new Scanner(System.in);

        print("\nHow many :");
        int numberOfProductsYouWant = scanner.nextInt();

        if(BuyerController.checkBalanceForBuying(product,numberOfProductsYouWant)){

            BuyerController.AddProductToCart(product,numberOfProductsYouWant);

            print("ADDED TO THE CART!\n");

        }else {

            print("YOU HAVE NOT ENOUGH BALANCE\nENTER ANY NUMBER TO CONTINUE...");
        }

        showProduct(product.getNumber());
    }

    //=================================================================================

    static void showBuyerProfileOptions() {

        int order = 10;

        while (order != 6) {
            print("\n1.SHOW MY PROFILE");
            print("2.EDIT MY PROFILE");
            print("3.INCREMENT BALANCE(request to admin)");
            print("4.SHOW MY BUYING CART");
            print("5.SHOW MY INVOICES");
            print("else.BACK to previous page\n");

            Scanner scanner = new Scanner(System.in);
            order = scanner.nextInt();
            scanner.nextLine();

            switch (order) {

                case 1 -> showMyProfile();

                case 2 -> editMyProfile();

                case 3 -> incrementBalance();

                case 4 -> showMyBuyingCart();

                case 5 -> showMyInvoices();
            }
            showBuyerMainMenu();
        }
    }

    //-------------------------------------------------------------------------

    static void showMyInvoices() {

        int index = 1;
        for (Invoice invoice : BuyerController.getInvoice()) {
            System.out.println(index + invoice.toString());
            index++;
        }

    }


    //-----------------------------------------------------------------------

    static void showMyBuyingCart() {
        print("YOUR CART ITEMS: " + BuyerController.getMyBuyingCart());
    }

    //-----------------------------------------------------------------------

    static void incrementBalance() {

        Scanner scanner = new Scanner(System.in);
        print("\nPLEASE ENTER AMOUNT THAT YOU WANT TO ADD TO YOUR BALANCE: ");

        double amount = scanner.nextDouble();

        BuyerController.setIncrementBalanceRequest(amount);

        print("YOUR REQUEST SENT FOR ADMIN\n");
    }

    //------------------------------------------------------------------------------------

    static void showMyProfile() {

        print(BuyerController.getMyProfile());
    }

    //--------------------------------------------------------------------------------------

    static void editMyProfile() {
        print("\nWHICH PROPERTY YOU WANT TO CHANGE? (1.USER NAME)(2.PASSWORD)(3.EMAIL)(4.PHONE NUMBER)\n");

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
        print("\nPLEASE ENTER THE NEW PHONE NUMBER: ");

        Scanner scanner = new Scanner(System.in);
        String phoneNumber;

        while (true) {
            phoneNumber = scanner.nextLine();

            if (LoginPageController.phoneNumberCheck(phoneNumber)) {

                BuyerController.setPhoneNumber(phoneNumber);

                print("\nYOUR LINKED PHONE NUMBER CHANGED SUCCESSFULLY\n");
                break;

            } else print("\nTHIS PHONE NUMBER IS NOT VALID , TRY ANOTHER ONE: ");
        }

    }

    //--------------------------------------------------

    static void changeEmail() {

        print("\nPLEASE ENTER THE NEW EMAIL: ");

        Scanner scanner = new Scanner(System.in);
        String email;

        while (true) {
            email = scanner.nextLine();

            if (LoginPageController.emailCheck(email)) {

                BuyerController.setEmail(email);

                print("\nYOUR EMAIL CHANGED SUCCESSFULLY\n");
                break;

            } else print("\nTHIS EMAIL IS NOT VALID , TRY ANOTHER ONE: ");
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

            } else print("\nTHIS USER NAME IS ALREADY EXIST , TRY ANOTHER ONE: ");
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

            } else print("\nTHIS PASSWORD IS NOT VALID , TRY ANOTHER ONE: ");
        }

    }

    //--------------------------------------------------------------------------------------


    //[][][][][][][][][][][][][][][][]][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]][][][]
    static void print(Object obj) {
        System.out.println(obj);
    }
}
