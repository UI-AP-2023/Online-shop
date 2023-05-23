package com.example.fase2.controller;

import com.example.fase2.model.product.digital_Product.PC;
import com.example.fase2.model.product.digital_Product.storageDevice.FlashMemory;
import com.example.fase2.model.product.digital_Product.storageDevice.SSD;
import com.example.fase2.model.product.edible.Edible;
import com.example.fase2.model.product.stationerySupplies.Office;
import com.example.fase2.model.product.stationerySupplies.Pen;
import com.example.fase2.model.product.stationerySupplies.Pencil;
import com.example.fase2.model.product.stationerySupplies.PencilType;
import com.example.fase2.model.product.vehicle.Bike;
import com.example.fase2.model.product.vehicle.BikeType;
import com.example.fase2.model.product.vehicle.Car;

public interface AdminController {

    static void addPC(int weight, int size, String name, int numberOfAvailable, String cpu_model, int ramMemoryCapacity, double price) {
        PC pc = new PC(weight, size, name, numberOfAvailable, cpu_model, ramMemoryCapacity, price);
    }


    static void addFlash(int usb_version, int capacity, int size, int weight, String name, int numberOfAvailable, double price) {
        FlashMemory flash = new FlashMemory(usb_version, capacity,size,weight,name,numberOfAvailable,price);
    }


    static void addSSD(int capacity, double readingSpeed, double writingSpeed, int weight, int size, String name, int numberOfAvailable, double price) {
        SSD ssd = new SSD(capacity, readingSpeed, writingSpeed,weight,size,name,numberOfAvailable,price);
    }

    static void addCar(String companyName, int engineVolume, Boolean automatic, String name, int nmbrAvailable, double price) {
        Car car = new Car(companyName,engineVolume,automatic,name,nmbrAvailable,price);
    }

    static void addBike(String companyName, String name, int nmbrAvailable, BikeType valueOf, double price) {
        Bike bike = new Bike(companyName,name,nmbrAvailable,valueOf,price);
    }


    static void addOffice(String country, int numberOfSheets, String paperType, String name, int nmbrAvailable, double price) {
        Office office = new Office(country,numberOfSheets,paperType,name,nmbrAvailable,price);
    }

    static void addPen(String country, String color, String name, int nmbrAvailable, double price) {
        Pen pen = new Pen(country,color,name,nmbrAvailable,price);
    }

    static void addPencil(String country, PencilType valueOf, String name, int nmbrAvailable, double price) {
        Pencil pencil = new Pencil(country,valueOf,name,nmbrAvailable,price);
    }

    static void addEdible(String productDate, String expirationDate, String name, int numberOfAvailable, double price) {
        Edible edible = new Edible(productDate,expirationDate,name,numberOfAvailable,price);
    }
}
