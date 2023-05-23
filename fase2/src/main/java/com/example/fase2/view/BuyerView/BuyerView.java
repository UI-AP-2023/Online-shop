package com.example.fase2.view.BuyerView;

import com.example.fase2.controller.BuyerController;
import com.example.fase2.controller.LoginPageController;
import com.example.fase2.model.ModelData;
import com.example.fase2.model.invoice_comment_score.Invoice;
import com.example.fase2.model.product.Product;
import com.example.fase2.model.product.ProductCategory;
import com.example.fase2.view.LoginPageView;

import java.util.Scanner;

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

            case 2 -> useFilters();

            case 3 -> showBuyerMainMenu();
        }

    }

    //----------------------------------------------------------

    static void useFilters() {

        print("1.PC, 2.FLASH, 3.SSD, 4.EDIBLE, 5.OFFICE, 6.PEN, 7.PENCIL, 8.BIKE, 9.CAR: ");

        Scanner scanner = new Scanner(System.in);
        int filterNum = scanner.nextInt();

        switch (filterNum) {

            case 1: showPCs();

            case 2: showFlashes();

            case 3: showSSDs();

            case 4: showEdibles();

            case 5: showOffices();

            case 6: showPens();

            case 7: showPencils();

            case 8: showBikes();

            case 9: showCars();

        }

    }

    //---------------------------------------------------------

    static void showPCs() {

        for (Product product : ModelData.getProducts()){
            if (product.getCategory() == ProductCategory.PC) {

                print(product);
            }
        }

        enterProductsPageNumber();
    }

    static void showFlashes() {

        for (Product product : ModelData.getProducts()){
            if (product.getCategory() == ProductCategory.FLASH) {

                print(product);
            }
        }

        enterProductsPageNumber();
    }

    static void showSSDs() {

        for (Product product : ModelData.getProducts()){
            if (product.getCategory() == ProductCategory.SSD) {

                print(product);
            }
        }

        enterProductsPageNumber();
    }

    static void showEdibles() {

        for (Product product : ModelData.getProducts()){
            if (product.getCategory() == ProductCategory.EDIBLE) {

                print(product);
            }
        }

        enterProductsPageNumber();
    }

    static void showPencils() {

        for (Product product : ModelData.getProducts()){
            if (product.getCategory() == ProductCategory.PENCIL) {

                print(product);
            }
        }

        enterProductsPageNumber();
    }

    static void showPens() {

        for (Product product : ModelData.getProducts()){
            if (product.getCategory() == ProductCategory.PEN) {

                print(product);
            }
        }

        enterProductsPageNumber();
    }

    static void showOffices() {

        for (Product product : ModelData.getProducts()){
            if (product.getCategory() == ProductCategory.OFFICE) {

                print(product);
            }
        }

        enterProductsPageNumber();
    }

    static void showBikes() {

        for (Product product : ModelData.getProducts()){
            if (product.getCategory() == ProductCategory.BIKE) {

                print(product);
            }
        }

        enterProductsPageNumber();
    }

    static void showCars() {

        for (Product product : ModelData.getProducts()){
            if (product.getCategory() == ProductCategory.CAR) {

                print(product);
            }
        }

        enterProductsPageNumber();
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

            case 3 -> rateThisProduct(product);

            case 4 -> showAllProducts();
        }
    }

    //-------------------------------------------------------

    static void rateThisProduct(Product product) {

        if (BuyerController.checkBoughtThisProduct(product)) {

            int score = 100;
            Scanner scanner = new Scanner(System.in);

            print("\nENTER YOUR SCORE:");

            while (!BuyerController.checkScore(score)) {

                score = scanner.nextInt();
                if (!BuyerController.checkScore(score)) {
                    BuyerController.addScore(product, score);

                    print("YOUR SCORE ADDED\n");

                    break;
                }

                print("PLEASE ENTER A NUMBER BETWEEN 1 AND 5: ");
            }

            showProduct(product.getNumber());
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

        if (BuyerController.checkNumberForBuying(product, numberOfProductsYouWant)) {

            BuyerController.AddProductToCart(product, numberOfProductsYouWant);

            print("ADDED TO THE CART!\n");

        } else {

            print("THIS PRODUCT IS NOT AVAILABLE AS MUCH AS YOU WANT!\nENTER ANY NUMBER TO CONTINUE...");
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
        print("\n\n1.Buy\n2.Remove a product\n3.Back");

        Scanner scanner = new Scanner(System.in);
        int order = scanner.nextInt();

        switch (order) {
            case 1 -> BuyerController.buyThisCart();

            case 2 -> removeThisFromCart();

            case 3 -> showBuyerProfileOptions();
        }
    }

    static void removeThisFromCart() {

        print("ENTER THE PRODUCT NUMBER THAT YOU WANT TO REMOVE:");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (BuyerController.removeThisFromCart(number)) {
            print("Removed!\n");
        } else {
            print("The product with this number is not in your cart");
        }

        showMyBuyingCart();
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

    static void printNotEnoughBalance() {
        print("\nYOUR BALANCE IS NOT ENOUGH!\n");

        showMyBuyingCart();

    }


    //[][][][][][][][][][][][][][][][]][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]][][][]
    static void print(Object obj) {
        System.out.println(obj);
    }


}
