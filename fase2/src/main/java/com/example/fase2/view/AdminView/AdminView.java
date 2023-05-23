package com.example.fase2.view.AdminView;

import com.example.fase2.controller.AdminController;
import com.example.fase2.model.product.stationerySupplies.PencilType;
import com.example.fase2.model.product.vehicle.BikeType;

import java.util.Scanner;

public interface AdminView {

    //-------------------------------------------------------------------------------------------------
    static void AdminShowOptions() {

        System.out.println(" PLEASE ENTER THE COMMAND (...ALL LETTERS SHOULD BE CAPITAL...) HELP FOR COMMANDS GUID\n");

        Scanner scanner = new Scanner(System.in);

        String order = "";

        while (!order.equals("EXIT")) {

            System.out.print("System\\Admin\\Command > ");
            order = scanner.next();

            switch (order) {

                case "ADD" -> addProduct();

                case "EDIT" -> { editProduct(); }


                case "REMOVE" -> {
                }

                case "SIGNUP" -> {
                }

                case "BALANCE" -> {
                }

                case "EXIT" -> {
                }

                case "HELP" -> {

                    System.out.println("ADD: add a product to the shop(you should write product properties after 'ADD')\n");
                    System.out.println("EDIT: edit a product's properties that exist in the shop (you should write the product's new properties after 'EDIT')\n");
                    System.out.println("REMOVE: remove a product from the shop\n");
                    System.out.println("SIGNUP: show sign up requests\n");
                    System.out.println("BALANCE: show balance increase requests\n");
                    System.out.println("EXIT: for exit :/\n");
                }

                default -> System.out.println(order + " not found...\n\n");
            }
        }
    }

    //--------------------------------------------------------------------------------------

    static void editProduct() {
        Scanner scanner = new Scanner(System.in);

        String productID = scanner.next();
    }


    //--------------------------------------------------------------------------------------

    static void addProduct() {

        Scanner scanner = new Scanner(System.in);

        String category = scanner.next();

        switch (category) {

            case "PC": addPC();

            case "FLASH": addFlash();

            case "SSD": addSSD();

            case "CAR": addCar();

            case "BIKE": addBike();

            case "OFFICE": addOffice();

            case "PEN": addPen();

            case "PENCIL": addPencil();

            case "EDIBLE": addEditable();

            default: print(category+"not found\n\n");
        }
    }

    static void addEditable() {
        Scanner scanner = new Scanner(System.in);

        String productDate= scanner.next();
        String ExpirationDate= scanner.next();
        String name= scanner.next();
        int numberOfAvailable= scanner.nextInt();
        double price= scanner.nextDouble();

        AdminController.addEdible(productDate,ExpirationDate,name,numberOfAvailable,price);
    }

    static void addPencil() {
        Scanner scanner = new Scanner(System.in);

        String country= scanner.next();
        String type=scanner.next();
        String name= scanner.next();
        int nmbrAvailable= scanner.nextInt();
        double price= scanner.nextDouble();

        AdminController.addPencil(country, PencilType.valueOf(type), name, nmbrAvailable, price);
    }

    static void addPen() {

        Scanner scanner = new Scanner(System.in);

        String country= scanner.next();
        String color=scanner.next();
        String name= scanner.next();
        int nmbrAvailable= scanner.nextInt();
        double price= scanner.nextDouble();

        AdminController.addPen(country,color,name,nmbrAvailable,price);

    }


    static void addOffice() {
        Scanner scanner = new Scanner(System.in);

        String country= scanner.next();
        int numberOfSheets= scanner.nextInt();
        String paperType= scanner.next();
        String name= scanner.next();
        int nmbrAvailable=scanner.nextInt();
        double price=scanner.nextDouble();

        AdminController.addOffice(country,numberOfSheets,paperType,name,nmbrAvailable,price);
    }

    static void addBike() {
        Scanner scanner = new Scanner(System.in);
        String companyName=scanner.next();
        String name= scanner.next();
        int nmbrAvailable= scanner.nextInt();
        String type= scanner.next();
        double price= scanner.nextDouble();

        AdminController.addBike(companyName,name,nmbrAvailable, BikeType.valueOf(type),price);
    }

    //---------------------------------------------

    static void addCar() {

        Scanner scanner = new Scanner(System.in);
        String companyName= scanner.next();
        int EngineVolume=scanner.nextInt();
        String automaticGearbox= scanner.next();
        String name= scanner.next();
        int nmbrAvailable= scanner.nextInt();
        double price= scanner.nextDouble();

        AdminController.addCar(companyName,EngineVolume,Boolean.valueOf(automaticGearbox),name,nmbrAvailable,price);
    }

    //---------------------------------------------

    static void addSSD() {
        Scanner scanner = new Scanner(System.in);

        int capacity= scanner.nextInt();
        double readingSpeed= scanner.nextDouble();
        double writingSpeed=scanner.nextDouble();
        int weight= scanner.nextInt();
        int size= scanner.nextInt();
        String name= scanner.next();
        int numberOfAvailable=scanner.nextInt();
        double price=scanner.nextDouble();

        AdminController.addSSD(capacity, readingSpeed, writingSpeed, weight,size,name,numberOfAvailable,price);
    }

    //-------------------------------------------

    static void addFlash() {

        Scanner scanner = new Scanner(System.in);
        int USB_Version = scanner.nextInt();
        int capacity = scanner.nextInt();
        int size = scanner.nextInt();
        int weight=scanner.nextInt();
        String name= scanner.next();
        int numberOfAvailable=scanner.nextInt();
        double price=scanner.nextDouble();

        AdminController.addFlash(USB_Version,capacity,size,weight,name,numberOfAvailable,price);
    }

    //--------------------------------------------
    static void addPC() {
        Scanner scanner = new Scanner(System.in);

        int weight= scanner.nextInt();

        int size= scanner.nextInt();

        String name= scanner.next();

        int numberOfAvailable=scanner.nextInt();

        String CPU_Model=scanner.next();

        int ramMemoryCapacity=scanner.nextInt();

        double price=scanner.nextDouble();

        AdminController.addPC(weight, size, name, numberOfAvailable, CPU_Model, ramMemoryCapacity, price);

    }


    //========================================================================

    static void print(Object obj) {
        System.out.println(obj);
    }

}