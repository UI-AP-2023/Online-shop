package com.example.fase2.model;

import com.example.fase2.model.product.*;
import com.example.fase2.model.product.digital_Product.DigitalProduct;
import com.example.fase2.model.product.digital_Product.PC;
import com.example.fase2.model.product.digital_Product.storageDevice.FlashMemory;
import com.example.fase2.model.product.digital_Product.storageDevice.SSD;
import com.example.fase2.model.product.digital_Product.storageDevice.StorageDevice;
import com.example.fase2.model.product.edible.Edible;
import com.example.fase2.model.product.stationerySupplies.Office;
import com.example.fase2.model.product.stationerySupplies.Pen;
import com.example.fase2.model.product.stationerySupplies.Pencil;
import com.example.fase2.model.product.stationerySupplies.StationerySupplies;
import com.example.fase2.model.product.vehicle.Bike;
import com.example.fase2.model.product.vehicle.Car;
import com.example.fase2.model.product.vehicle.Vehicle;
import com.example.fase2.model.userAccount.*;

import java.util.ArrayList;

public abstract class ModelData {

    private static final ArrayList<Buyer> customers = new ArrayList<>();

    //---------------------------------------------------------

    private static final ArrayList<Product> products = new ArrayList<>();

    //-------------------------------------------------------

    //----------------------------------------------------

    //----------------------------------------------------------------------
    /**
     * The only admin the shop has
     */
    private static final Admin admin = Admin.getAdmin("admin", "admin41148@gmail.com", "09375509788" , "admin");

    //-------------------------------------------------------

    private static Buyer you = null;

    //------------------------------------------------------

    public static ArrayList<Buyer> getCustomers() {
        return customers;
    }

    //------------------------------------------------------------

    public static ArrayList<Product> getProducts() {
        return products;
    }

    //--------------------------------------------------------------


    //-------------------------------------------------------

    public static Admin getAdmin() {
        return admin;
    }

    //--------------------------------------------------------

    public static void addCustomer(Buyer customer) {
        customers.add(customer);
    }

    //---------------------------------------------------------


    //------------------------------------------------------------------------

    public static Buyer getYou() {
        return you;
    }

    //--------------------------------------------------------------------


    public static void setYou(Buyer you) {
        ModelData.you = you;
    }

    //--------------------------------------------------------------------


    private static final ArrayList <PC> PCs = new ArrayList<>();
    private static final ArrayList <FlashMemory> flashes = new ArrayList<>();
    private static final ArrayList <SSD> SSDs = new ArrayList<>();
    private static final ArrayList <Car> Cars = new ArrayList<>();
    private static final ArrayList <Bike> Bikes = new ArrayList<>();
    private static final ArrayList <Office> offices = new ArrayList<>();
    private static final ArrayList <Pen> pens = new ArrayList<>();
    private static final ArrayList <Pencil> pencils = new ArrayList<>();
    private static final ArrayList <Edible> edibles = new ArrayList<>();
    private static final ArrayList<DigitalProduct> digitalProducts = new ArrayList<>();
    private static final ArrayList<StorageDevice> storageDevices = new ArrayList<>();
    private static final ArrayList<StationerySupplies> stationerySupplies = new ArrayList<>();
    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static ArrayList<PC> getPCs() {
        return PCs;
    }

    public static ArrayList<FlashMemory> getFlashes() {
        return flashes;
    }

    public static ArrayList<SSD> getSSDs() {
        return SSDs;
    }

    public static ArrayList<Car> getCars() {
        return Cars;
    }

    public static ArrayList<Bike> getBikes() {
        return Bikes;
    }

    public static ArrayList<Office> getOffices() {
        return offices;
    }

    public static ArrayList<Pen> getPens() {
        return pens;
    }

    public static ArrayList<Pencil> getPencils() {
        return pencils;
    }

    public static ArrayList<Edible> getEdibles() {
        return edibles;
    }

    public static ArrayList<DigitalProduct> getDigitalProducts() {
        return digitalProducts;
    }

    public static ArrayList<StorageDevice> getStorageDevices() {
        return storageDevices;
    }

    public static ArrayList<StationerySupplies> getStationerySupplies() {
        return stationerySupplies;
    }

    public static ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    //--------------------------------------------------------------------

    //----------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------


    //--------------------------------------------------------------------




}
