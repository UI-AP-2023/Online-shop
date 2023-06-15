package com.example.phase2.view.AdminView;

import com.example.fase2.exceptions.InvalidLoginException;
import com.example.phase2.controller.AdminController;
import com.example.phase2.exceptions.InvalidID;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.product.Product;
import com.example.phase2.model.product.stationerySupplies.PencilType;
import com.example.phase2.model.product.vehicle.BikeType;
import com.example.phase2.view.BuyerView.LoginPageView;

import java.util.Objects;
import java.util.Scanner;

public interface AdminView {

    //-------------------------------------------------------------------------------------------------
    static void AdminShowOptions() throws InvalidLoginException {

        System.out.println(" PLEASE ENTER THE COMMAND (...ALL LETTERS SHOULD BE CAPITAL...) HELP FOR COMMANDS GUID\n");

        Scanner scanner = new Scanner(System.in);

        String order = "";

        while (!order.equals("EXIT")) {

            System.out.print("System\\Admin\\Command > ");
            order = scanner.next();

            switch (order) {

                case "ADD" -> addProduct();

                case "EDIT" -> editProduct();

                case "REMOVE" -> removeProductView();

                case "DISCOUNT" -> makeDiscountCodeView();

                case "DISCOUNTABLE" -> setDiscountablePercentage();

                case "EXIT" -> {
                    ModelData.setYou(null);
                    LoginPageView.showLoginPage();
                }

                case "HELP" -> {

                    print("ADD: add a product to the shop(you should write product properties after 'ADD')\n");
                    print("EDIT: edit a product's properties that exist in the shop (you should write the product's new properties after 'EDIT')\n");
                    print("REMOVE: remove a product from the shop\n");
                    print("DISCOUNT: make discount code for carts\n");
                    print("DISCOUNTABLE: discount for Discountable products");
                    print("EXIT: for exit :/\n");
                }

                default -> print(order + " not found...\n\n");
            }
        }
    }

    static void setDiscountablePercentage() {

        Scanner sc = new Scanner(System.in);

        int discountPercentage = sc.nextInt();

        AdminController.setDiscountPercentage(discountPercentage);
    }

    static void makeDiscountCodeView() {

        Scanner scanner = new Scanner(System.in);

        String order = scanner.next();

        int discountPercent = scanner.nextInt();
        int daysRemain = scanner.nextInt();
        int capacity = scanner.nextInt();

        if (Objects.equals(order, "random")) {

            AdminController.addRandomDiscountCode(discountPercent, daysRemain, capacity);
        } else  {

            AdminController.addThisDiscountCode(discountPercent, daysRemain, capacity, order);
        }
    }

    static void removeProductView() {

        Scanner scanner = new Scanner(System.in);

        String removingProductID = scanner.nextLine();

        try {

            AdminController.removeProductView(removingProductID);
        } catch (InvalidID e) {

            System.out.println("The product ID is not found\n");
        }
    }

    //--------------------------------------------------------------------------------------

    static void editProduct() {

        Scanner scanner = new Scanner(System.in);

        String productID = scanner.nextLine();

        try {

            AdminController.editProductController(productID);
        } catch (InvalidID e) {

            System.out.println("this product is not found\n");
        }
    }


    //--------------------------------------------------------------------------------------

    static void addProduct() {

        Scanner scanner = new Scanner(System.in);

        String category = scanner.next();

        switch (category) {

            case "PC"->
                addPC();

            case "FLASH"->
                addFlash();

            case "SSD"->
                addSSD();

            case "CAR"->
                addCar();

            case "BIKE"->
                addBike();

            case "OFFICE"->
                addOffice();

            case "PEN"->
                addPen();

            case "PENCIL"->
                addPencil();

            case "EDIBLE"->
                addEdible();

            default->
                print(category + "not found\n\n");
        }
    }
    //--------------------------------------------------------------------------------------

    static void addEdible() {
        Scanner scanner = new Scanner(System.in);

        String productDate = scanner.next();
        String ExpirationDate = scanner.next();
        String name = scanner.next();
        int numberOfAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.addEdible(productDate, ExpirationDate, name, numberOfAvailable, price);
    }
    //--------------------------------------------------------------------------------------

    static void addPencil() {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.next();
        String type = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.addPencil(country, PencilType.valueOf(type), name, nmbrAvailable, price);
    }
    //--------------------------------------------------------------------------------------

    static void addPen() {

        Scanner scanner = new Scanner(System.in);

        String country = scanner.next();
        String color = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.addPen(country, color, name, nmbrAvailable, price);

    }
    //--------------------------------------------------------------------------------------


    static void addOffice() {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.next();
        int numberOfSheets = scanner.nextInt();
        String paperType = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.addOffice(country, numberOfSheets, paperType, name, nmbrAvailable, price);
    }
    //--------------------------------------------------------------------------------------

    static void addBike() {
        Scanner scanner = new Scanner(System.in);
        String companyName = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        String type = scanner.next();
        double price = scanner.nextDouble();

        AdminController.addBike(companyName, name, nmbrAvailable, BikeType.valueOf(type), price);
    }

    //---------------------------------------------

    static void addCar() {

        Scanner scanner = new Scanner(System.in);
        String companyName = scanner.next();
        int EngineVolume = scanner.nextInt();
        String automaticGearbox = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.addCar(companyName, EngineVolume, Boolean.valueOf(automaticGearbox), name, nmbrAvailable, price);
    }

    //---------------------------------------------

    static void addSSD() {
        Scanner scanner = new Scanner(System.in);

        int capacity = scanner.nextInt();
        double readingSpeed = scanner.nextDouble();
        double writingSpeed = scanner.nextDouble();
        int weight = scanner.nextInt();
        int size = scanner.nextInt();
        String name = scanner.next();
        int numberOfAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.addSSD(capacity, readingSpeed, writingSpeed, weight, size, name, numberOfAvailable, price);
    }

    //-------------------------------------------

    static void addFlash() {

        Scanner scanner = new Scanner(System.in);
        int USB_Version = scanner.nextInt();
        int capacity = scanner.nextInt();
        int size = scanner.nextInt();
        int weight = scanner.nextInt();
        String name = scanner.next();
        int numberOfAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.addFlash(USB_Version, capacity, size, weight, name, numberOfAvailable, price);
    }

    //--------------------------------------------
    static void addPC() {
        Scanner scanner = new Scanner(System.in);

        int weight = scanner.nextInt();

        int size = scanner.nextInt();

        String name = scanner.next();

        int numberOfAvailable = scanner.nextInt();

        String CPU_Model = scanner.next();

        int ramMemoryCapacity = scanner.nextInt();

        double price = scanner.nextDouble();

        AdminController.addPC(weight, size, name, numberOfAvailable, CPU_Model, ramMemoryCapacity, price);

    }


    //========================================================================

    static void print(Object obj) {
        System.out.println(obj);
    }

    static void editThisPCView(Product product) {

        Scanner scanner = new Scanner(System.in);

        int weight = scanner.nextInt();

        int size = scanner.nextInt();

        String name = scanner.next();

        int numberOfAvailable = scanner.nextInt();

        String CPU_Model = scanner.next();

        int ramMemoryCapacity = scanner.nextInt();

        double price = scanner.nextDouble();

        AdminController.editThisPC(product, weight, size, name, numberOfAvailable, CPU_Model, ramMemoryCapacity, price);
    }

    static void editThisFLASHView(Product product) {


        Scanner scanner = new Scanner(System.in);
        int USB_Version = scanner.nextInt();
        int capacity = scanner.nextInt();
        int size = scanner.nextInt();
        int weight = scanner.nextInt();
        String name = scanner.next();
        int numberOfAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.editThisFLASH(product, USB_Version, capacity, size, weight, name, numberOfAvailable, price);
    }

    static void editThisSSDView(Product product) {

        Scanner scanner = new Scanner(System.in);

        int capacity = scanner.nextInt();
        double readingSpeed = scanner.nextDouble();
        double writingSpeed = scanner.nextDouble();
        int weight = scanner.nextInt();
        int size = scanner.nextInt();
        String name = scanner.next();
        int numberOfAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.editThisSSD(product, capacity, readingSpeed, writingSpeed, weight, size, name, numberOfAvailable, price);
    }

    static void editThisCARView(Product product) {

        Scanner scanner = new Scanner(System.in);
        String companyName = scanner.next();
        int EngineVolume = scanner.nextInt();
        String automaticGearbox = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.editThisCAR(product, companyName, EngineVolume, Boolean.valueOf(automaticGearbox), name, nmbrAvailable, price);
    }

    static void editThisBikeView(Product product) {

        Scanner scanner = new Scanner(System.in);

        String companyName = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        String type = scanner.next();
        double price = scanner.nextDouble();

        AdminController.editThisBikeController(product, name, nmbrAvailable, BikeType.valueOf(type), price, companyName);
    }

    static void editThisEdibleView(Product product) {

        Scanner scanner = new Scanner(System.in);

        String productDate = scanner.next();
        String ExpirationDate = scanner.next();
        String name = scanner.next();
        int numberOfAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.editThisEdibleController(product, name, numberOfAvailable, productDate, ExpirationDate, price);
    }

    static void editThisOfficeView(Product product) {

        Scanner scanner = new Scanner(System.in);

        String country = scanner.next();
        int numberOfSheets = scanner.nextInt();
        String paperType = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.EditThisOfficeController(product, name, numberOfSheets, paperType, country, nmbrAvailable, price);
    }

    static void EditThisPenView(Product product) {


        Scanner scanner = new Scanner(System.in);

        String country = scanner.next();
        String color = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.EditThisPenController(product, name, country, color, nmbrAvailable, price);
    }

    static void editThisPencilView(Product product) {

        Scanner scanner = new Scanner(System.in);

        String country = scanner.next();
        String type = scanner.next();
        String name = scanner.next();
        int nmbrAvailable = scanner.nextInt();
        double price = scanner.nextDouble();

        AdminController.editThisPencilController(product, name, country, type, nmbrAvailable, price);
    }

    static void printDiscountCode(String discountCode) {
        print("\""+discountCode+"\"");
    }
}
