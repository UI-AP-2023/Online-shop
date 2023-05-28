package com.example.phase2.controller;

import com.example.phase2.exceptions.InvalidID;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.product.Product;
import com.example.phase2.model.product.digital_Product.PC;
import com.example.phase2.model.product.digital_Product.storageDevice.FlashMemory;
import com.example.phase2.model.product.digital_Product.storageDevice.SSD;
import com.example.phase2.model.product.edible.Edible;
import com.example.phase2.model.product.stationerySupplies.Office;
import com.example.phase2.model.product.stationerySupplies.Pen;
import com.example.phase2.model.product.stationerySupplies.Pencil;
import com.example.phase2.model.product.stationerySupplies.PencilType;
import com.example.phase2.model.product.vehicle.Bike;
import com.example.phase2.model.product.vehicle.BikeType;
import com.example.phase2.model.product.vehicle.Car;
import com.example.phase2.view.AdminView.AdminView;

import java.util.Objects;

public interface AdminController {

    static void addPC(int weight, int size, String name, int numberOfAvailable, String cpu_model, int ramMemoryCapacity, double price) {
        PC pc = new PC(weight, size, name, numberOfAvailable, cpu_model, ramMemoryCapacity, price);
    }

//-----------------------------------------------

    static void addFlash(int usb_version, int capacity, int size, int weight, String name, int numberOfAvailable, double price) {
        FlashMemory flash = new FlashMemory(usb_version, capacity,size,weight,name,numberOfAvailable,price);
    }
//-----------------------------------------------


    static void addSSD(int capacity, double readingSpeed, double writingSpeed, int weight, int size, String name, int numberOfAvailable, double price) {
        SSD ssd = new SSD(capacity, readingSpeed, writingSpeed,weight,size,name,numberOfAvailable,price);
    }
//-----------------------------------------------

    static void addCar(String companyName, int engineVolume, Boolean automatic, String name, int nmbrAvailable, double price) {
        Car car = new Car(companyName,engineVolume,automatic,name,nmbrAvailable,price);
    }
//-----------------------------------------------

    static void addBike(String companyName, String name, int nmbrAvailable, BikeType valueOf, double price) {
        Bike bike = new Bike(companyName,name,nmbrAvailable,valueOf,price);
    }

//-----------------------------------------------

    static void addOffice(String country, int numberOfSheets, String paperType, String name, int nmbrAvailable, double price) {
        Office office = new Office(country,numberOfSheets,paperType,name,nmbrAvailable,price);
    }
//-----------------------------------------------

    static void addPen(String country, String color, String name, int nmbrAvailable, double price) {
        Pen pen = new Pen(country,color,name,nmbrAvailable,price);
    }
//-----------------------------------------------

    static void addPencil(String country, PencilType valueOf, String name, int nmbrAvailable, double price) {
        Pencil pencil = new Pencil(country,valueOf,name,nmbrAvailable,price);
    }
//-----------------------------------------------

    static void addEdible(String productDate, String expirationDate, String name, int numberOfAvailable, double price) {
        Edible edible = new Edible(productDate,expirationDate,name,numberOfAvailable,price);
    }
//-----------------------------------------------

    static void editProductController(String productID) throws InvalidID {

        for (Product product : ModelData.getProducts()){

            if(Objects.equals(product.getID(), productID)){

                switch (product.getCategory()){

                    case PC -> AdminView.editThisPCView(product);

                    case FLASH -> AdminView.editThisFLASHView(product);

                    case SSD -> AdminView.editThisSSDView(product);

                    case CAR -> AdminView.editThisCARView(product);

                    case BIKE -> AdminView.editThisBikeView(product);

                    case EDIBLE -> AdminView.editThisEdibleView(product);

                    case OFFICE -> AdminView.editThisOfficeView(product);

                    case PEN -> AdminView.EditThisPenView(product);

                    case PENCIL -> AdminView.editThisPencilView(product);
                }

                return;
            }
        }
        throw new InvalidID();
    }

    static void editThisCAR(Product product, String companyName, int engineVolume
            , Boolean aBoolean, String name, int nmbrAvailable, double price) {

        Car car = (Car) product;

        car.setName(name);
        car.setPrice(price);
        car.setAutomaticGearbox(aBoolean);
        car.setCompanyName(companyName);
        car.setNumberOfAvailable(nmbrAvailable);
        car.setEngineVolume(engineVolume);
    }

    //------------------------------------------------------

    static void editThisSSD(Product product, int capacity, double readingSpeed
            , double writingSpeed, int weight, int size, String name, int numberOfAvailable, double price) {


        SSD ssd = (SSD) product;

        ssd.setName(name);
        ssd.setReadingSpeed(readingSpeed);
        ssd.setWritingSpeed(writingSpeed);
        ssd.setCapacity(capacity);
        ssd.setSize(size);
        ssd.setWeight(weight);
        ssd.setNumberOfAvailable(numberOfAvailable);
        ssd.setPrice(price);
    }

    //------------------------------------------------------
    static void editThisFLASH(Product product, int USB_Version, int capacity
            , int size, int weight, String name, int numberOfAvailable, double price) {

        FlashMemory flash = (FlashMemory) product;

        flash.setUSB_Version(USB_Version);
        flash.setCapacity(capacity);
        flash.setSize(size);
        flash.setName(name);
        flash.setWeight(weight);
        flash.setNumberOfAvailable(numberOfAvailable);
        flash.setPrice(price);

    }
//------------------------------------------------------

    static void editThisPC(Product product, int weight, int size, String name,
                           int numberOfAvailable, String CPU_Model, int ramMemoryCapacity, double price) {

        PC pc = (PC) product;

        pc.setName(name);
        pc.setNumberOfAvailable(numberOfAvailable);
        pc.setPrice(price);
        pc.setSize(size);
        pc.setWeight(weight);
        pc.setCPU_Model(CPU_Model);
        pc.setRamMemoryCapacity(ramMemoryCapacity);
    }

    static void editThisBikeController(Product product, String name, int nmbrAvailable,
                                       BikeType bikeType, double price, String companyName) {

        Bike bike = (Bike) product;

        bike.setName(name);
        bike.setCompanyName(companyName);
        bike.setPrice(price);
        bike.setNumberOfAvailable(nmbrAvailable);
        bike.setBikeType(bikeType);

    }

    static void editThisEdibleController(Product product, String name, int numberOfAvailable,
                                         String produceDate, String expirationDate, double price) {

        Edible edible = (Edible) product;

        edible.setName(name);
        edible.setNumberOfAvailable(numberOfAvailable);
        edible.setProduceDate(produceDate);
        edible.setExpirationDate(expirationDate);
        edible.setPrice(price);
    }

    static void EditThisOfficeController(Product product, String name, int numberOfSheets,
                                         String paperType, String country, int nmbrAvailable, double price) {

        Office office = (Office) product;

        office.setName(name);
        office.setNumberOfAvailable(nmbrAvailable);
        office.setNumberOfSheets(numberOfSheets);
        office.setPaperType(paperType);
        office.setCountry(country);
        office.setPrice(price);
    }

    static void EditThisPenController(Product product, String name, String country,
                                      String color, int nmbrAvailable, double price) {

        Pen pen = (Pen) product;

        pen.setName(name);
        pen.setCountry(country);
        pen.setColor(color);
        pen.setNumberOfAvailable(nmbrAvailable);
        pen.setPrice(price);
    }

    static void editThisPencilController(Product product, String name,
                                         String country, String type, int nmbrAvailable, double price) {

        Pencil pencil = (Pencil) product;

        pencil.setName(name);
        pencil.setCountry(country);
        pencil.setType(PencilType.valueOf(type));
        pencil.setNumberOfAvailable(nmbrAvailable);
        pencil.setPrice(price);
    }

    static void removeProductView(String removingProductID) throws InvalidID {

        for (Product product : ModelData.getProducts()){

            if(Objects.equals(product.getID(), removingProductID)){

                ModelData.getProducts().remove(product);

                return;
            }
        }

        throw new InvalidID();
    }
}
