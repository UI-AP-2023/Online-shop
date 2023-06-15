package com.example.phase2.view.BuyerView;

import com.example.phase2.controller.BuyerController;
import com.example.phase2.controller.LoginPageController;
import com.example.phase2.exceptions.*;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.invoice_comment_score.Invoice;
import com.example.phase2.model.product.Product;
import com.example.phase2.model.product.digital_Product.PC;
import com.example.phase2.model.product.digital_Product.storageDevice.FlashMemory;
import com.example.phase2.model.product.digital_Product.storageDevice.SSD;
import com.example.phase2.model.product.edible.Edible;
import com.example.phase2.model.product.stationerySupplies.Office;
import com.example.phase2.model.product.stationerySupplies.Pen;
import com.example.phase2.model.product.stationerySupplies.Pencil;
import com.example.phase2.model.product.vehicle.Bike;
import com.example.phase2.model.product.vehicle.Car;

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

            case 3 ->LoginPageView.showLoginPage();

        }
    }

    //---------------------------------------------------------------------------------

    static void showProductsPageOptions() {
        print("\n1. SHOW ALL OF PRODUCTS IN THE SHOP");
        print("2. FILTER PRODUCTS BY CATEGORIES");
        print("3. FILTER PRODUCT BY PRICE\n");
        print("4. RETURN TO PREVIOUS PAGE\n");

        Scanner scanner = new Scanner(System.in);
        int order = scanner.nextInt();

        switch (order) {

            case 1 -> showAllProducts(2000000000);

            case 2 -> useCategoryFilters();

            case 3 -> usePriceFilters();

            case 4 -> showBuyerMainMenu();
        }

    }

    static void usePriceFilters() {

        print("MAXIMUM PRICE:");

        Scanner scanner = new Scanner(System.in);

        int maximumPrice = scanner.nextInt();

        print("WHICH CATEGORY: ");
        print("1.PC, 2.FLASH, 3.SSD, 4.EDIBLE, 5.OFFICE, 6.PEN, 7.PENCIL, 8.BIKE, 9.CAR: ");

        int filterNum = scanner.nextInt();

        switch (filterNum) {

            case 1:
                showPCs(maximumPrice);

            case 2:
                showFlashes(maximumPrice);

            case 3:
                showSSDs(maximumPrice);

            case 4:
                showEdibles(maximumPrice);

            case 5:
                showOffices(maximumPrice);

            case 6:
                showPens(maximumPrice);

            case 7:
                showPencils(maximumPrice);

            case 8:
                showBikes(maximumPrice);

            case 9:
                showCars(maximumPrice);

        }

    }

    //----------------------------------------------------------

    static void useCategoryFilters() {

        print("1.PC, 2.FLASH, 3.SSD, 4.EDIBLE, 5.OFFICE, 6.PEN, 7.PENCIL, 8.BIKE, 9.CAR: ");

        Scanner scanner = new Scanner(System.in);
        int filterNum = scanner.nextInt();

        switch (filterNum) {

            case 1:
                showPCs(2000000000);

            case 2:
                showFlashes(2000000000);

            case 3:
                showSSDs(2000000000);

            case 4:
                showEdibles(2000000000);

            case 5:
                showOffices(2000000000);

            case 6:
                showPens(2000000000);

            case 7:
                showPencils(2000000000);

            case 8:
                showBikes(2000000000);

            case 9:
                showCars(2000000000);

        }

    }

    //---------------------------------------------------------

    static void showPCs(int maxPrice) {

        for (PC pc : ModelData.getPCs()) {

            if (pc.getPrice() <= maxPrice) {
                print(pc);
            }
        }

        enterProductsPageNumber();
    }

    static void showFlashes(int maxPrice) {

        for (FlashMemory flash : ModelData.getFlashes()) {

            if (flash.getPrice() <= maxPrice) {
                print(flash);
            }
        }

        enterProductsPageNumber();
    }

    static void showSSDs(int maxPrice) {

        for (SSD ssd : ModelData.getSSDs()) {

            if (ssd.getPrice() <= maxPrice) {
                print(ssd);
            }
        }

        enterProductsPageNumber();
    }

    static void showEdibles(int maxPrice) {

        for (Edible edible : ModelData.getEdibles()) {

            if (edible.getPrice() <= maxPrice) {
                print(edible);
            }
        }

        enterProductsPageNumber();
    }

    static void showPencils(int maxPrice) {

        for (Pencil pencil : ModelData.getPencils()) {

            if (pencil.getPrice() <= maxPrice) {
                print(pencil);
            }
        }

        enterProductsPageNumber();
    }

    static void showPens(int maxPrice) {

        for (Pen pen : ModelData.getPens()) {

            if (pen.getPrice() <= maxPrice) {
                print(pen);
            }
        }

        enterProductsPageNumber();
    }

    static void showOffices(int maxPrice) {

        for (Office off : ModelData.getOffices()) {

            if (off.getPrice() <= maxPrice) {
                print(off);
            }
        }
        enterProductsPageNumber();
    }

    static void showBikes(int maxPrice) {

        for (Bike bike : ModelData.getBikes()) {

            if (bike.getPrice() <= maxPrice) {
                print(bike);
            }
        }
        enterProductsPageNumber();
    }

    static void showCars(int maxPrice) {

        for (Car car : ModelData.getCars()) {

            if (car.getPrice() <= maxPrice) {
                print(car);
            }
        }

        enterProductsPageNumber();
    }


    //--------------------------------------------------

    static void showAllProducts(int maxPrice) {

        for (Product product : ModelData.getProducts()) {

            if (product.getPrice() <= maxPrice) {
                print(product.toString());
            }
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

//        if (BuyerController.getThisProduct(numberOfProduct) != null) {

        try {
            print(BuyerController.getThisProduct(numberOfProduct));

            BuyerView.showThisProductOptions(BuyerController.getThisProduct(numberOfProduct));

        } catch (NullPointerException e) {
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

            case 4 -> showAllProducts(2000000000);
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
        } else
            print("You did not buy this product!\n\n");

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

            BuyerController.addProductToCart(product, numberOfProductsYouWant);

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
            case 1 -> buyThisCartView();//BuyerController.buyThisCart();

            case 2 -> removeThisFromCart();

            case 3 -> showBuyerProfileOptions();
        }
    }

    static void buyThisCartView() {

        print("1.Use discount code\n" +
                "2.Buy with no discount code");

        Scanner scanner = new Scanner(System.in);

        int order = scanner.nextInt();

        switch (order){

            case 1 -> giveDiscountCode();

            case 2 -> BuyerController.buyThisCart("");
        }
    }

    static void giveDiscountCode() {
        print("Discount code:");

        Scanner sc = new Scanner(System.in);

        String code= sc.nextLine();

        BuyerController.buyThisCart(code);
    }

    static void removeThisFromCart() {

        print("ENTER THE PRODUCT NUMBER THAT YOU WANT TO REMOVE:");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        try {
            BuyerController.removeThisFromCart(number);
            print("Removed!\n");

        } catch (InvalidProductNumber e) {
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

            try {
                LoginPageController.phoneNumberCheck(phoneNumber);

                BuyerController.setPhoneNumber(phoneNumber);

                print("\nYOUR LINKED PHONE NUMBER CHANGED SUCCESSFULLY\n");
                break;

            } catch (InvalidPhoneNumberException e) {
                print("\nTHIS PHONE NUMBER IS NOT VALID , TRY ANOTHER ONE: ");
            }
        }

    }

    //--------------------------------------------------

    static void changeEmail() {

        print("\nPLEASE ENTER THE NEW EMAIL: ");

        Scanner scanner = new Scanner(System.in);
        String email;

        while (true) {
            email = scanner.nextLine();

            try {

                LoginPageController.emailCheck(email);

                BuyerController.setEmail(email);

                print("\nYOUR EMAIL CHANGED SUCCESSFULLY\n");
                break;

            } catch (InvalidEmailException e) {
                print("\nTHIS EMAIL IS NOT VALID , TRY ANOTHER ONE: ");
            }
        }


    }

    //-------------------------

    static void changeUserName() {

        print("\nENTER YOUR NEW USER NAME: ");
        Scanner scanner = new Scanner(System.in);
        String userName;

        while (true) {
            userName = scanner.nextLine();

            try {


                BuyerController.checkUserName(userName);

                BuyerController.setUserName(userName);

                print("\nYOUR USER NAME CHANGED SUCCESSFULLY\n");
                break;

            } catch (InUsedUserNameException e) {
                print("\nTHIS USER NAME IS ALREADY EXIST , TRY ANOTHER ONE: ");
            }
        }

    }

    //----------------------------------------------------------------------------------

    static void changePassword() {

        print("\nENTER YOUR NEW Password(4 letters at least and it should be made by uppercase, lowercase & special characters & digits ): ");
        Scanner scanner = new Scanner(System.in);
        String password;

        while (true) {
            password = scanner.nextLine();

            try {
                LoginPageController.passwordCheck(password);

                BuyerController.setPassword(password);

                print("\nYOUR PASSWORD CHANGED SUCCESSFULLY\n");
                break;

            } catch (InvalidPasswordException e) {
                print("\nTHIS PASSWORD IS NOT VALID , TRY ANOTHER ONE: ");
            }
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


    static void printThanksForShopping() {
        print("Thanks for your Shopping!\n\n");
    }

    static void discountCodeNotFound() {

        print("discount code doesnt found!");

        buyThisCartView();
    }
}
