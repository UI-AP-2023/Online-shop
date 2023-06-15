package com.example.phase2.model.adminTest;

import com.example.phase2.controller.AdminController;
import com.example.phase2.model.ModelData;
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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdminControllerTest {

    @Test
    void addPCTest() {

        PC pc = new PC(2, 16, "Tuf", 20, "corei7", 16, 1000);

        boolean found = false;

        for (PC pc1 : ModelData.getPCs()) {
            if (pc1.equals(pc)) {
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
    }

    @Test
    void addFlashTest() {

        FlashMemory sut = new FlashMemory(2, 16, 5, 1, "zedra", 16, 1000);

        boolean found = false;

        for (FlashMemory flashMemory : ModelData.getFlashes()) {
            if (flashMemory.equals(sut)) {
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
    }

    @Test
    void addSSDTest() {

        SSD sut = new SSD(2, 16, 4800, 20, 10, "Aveg12", 10, 300);

        boolean found = false;

        for (SSD ssd : ModelData.getSSDs()) {
            if (ssd.equals(sut)) {
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
    }

    @Test
    void addCarTest() {

        Car sut = new Car("BMW", 3800, true, "Z4", 10, 15000);

        boolean found = false;

        for (Car car : ModelData.getCars()) {
            if (car.equals(sut)) {
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
    }

    @Test
    void addBikeTest() {

        Bike sut = new Bike("BMW", "kooh", 12, BikeType.ROAD, 12000);

        boolean found = false;

        for (Bike bike : ModelData.getBikes()) {
            if (bike.equals(sut)) {
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
    }

    @Test
    void addOfficeTest() {

        Office sut = new Office("BMW", 3800, "DerakhteGerdoo", "Z4", 10, 15000);

        boolean found = false;

        for (Office office : ModelData.getOffices()) {
            if (office.equals(sut)) {
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
    }

    @Test
    void addPenTest() {

        Pen sut = new Pen("BMW", "GREEN", "faber", 20, 10);

        boolean found = false;

        for (Pen pen : ModelData.getPens()) {
            if (pen.equals(sut)) {
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
    }

    @Test
    void addPencilTest() {

        Pencil sut = new Pencil("BMW", PencilType.HB, "abbass", 20, 10);

        boolean found = false;

        for (Pencil pen : ModelData.getPencils()) {
            if (pen.equals(sut)) {
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
    }


    @Test
    void addEdibleTest() {

        Edible sut = new Edible("20.1.1403", "20.1.1404", "titap", 1200, 10);

        boolean found = false;

        for (Edible edible : ModelData.getEdibles()) {
            if (edible.equals(sut)) {
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
    }

    @Test
    void editThisCARTest() {

        Car sut = new Car("BMW", 3800, true, "Z4", 10, 15000);

        AdminController.editThisCAR(sut, "benz", 5000, true, "G63", 10, 50000);


        assertTrue(sut.isAutomaticGearbox());

        assertEquals(sut.getEngineVolume(), 5000);
        assertEquals(sut.getPrice(), 50000);
        assertEquals(sut.getName(), "G63");
        assertEquals(sut.getCompanyName(), "benz");
    }

    @Test
    void editThisSSDTest() {

        SSD sut = new SSD(2, 16, 4800, 20, 10, "Aveg12", 10, 300);

        AdminController.editThisSSD(sut, 6, 16, 4800, 20, 10,
                "Aveg12", 10, 300);


        int expected = 6;
        int actual = sut.getCapacity();

        assertEquals(expected, actual);
    }

    @Test
    void editThisFLASHTest() {

        FlashMemory sut = new FlashMemory(2, 16, 5, 1, "zedra", 16, 1000);

        AdminController.editThisFLASH(sut, 3, 16, 5, 1, "zedra"
                , 16, 1000);

        int expected = 3;
        int actual = sut.getUSB_Version();

        assertEquals(expected, actual);
    }

    @Test
    void editThisPCTest() {

        PC sut = new PC(2, 16, "Tuf", 20,
                "corei7", 16, 1000);

        AdminController.editThisPC(sut, 5, 16, "Tuf", 20,
                "corei7", 16, 1000);

        double expected = 5;
        double actual = sut.getWeight();

        assertEquals(expected, actual);
    }

    @Test
    void editThisBikeControllerTest() {

        Bike sut = new Bike("BMW", "kooh", 12, BikeType.ROAD, 12000);

        AdminController.editThisBikeController(sut, "kooh", 12, BikeType.ROAD, 6000, "BMW");

        double expected = 5;
        double actual = sut.getPrice();

        assertEquals(expected, actual);
    }

    @Test
    void editThisEdibleControllerTest() {

        Edible sut = new Edible("20.1.1403", "20.1.1404", "titap", 1200, 10);

        AdminController.editThisEdibleController(sut, "crosant", 12000,
                "20.1.1403", "20.1.1404", 10);

        String expected = "crosant";
        String actual = sut.getName();

        assertEquals(expected, actual);
    }

    @Test
    void editThisOfficeControllerTest() {

        Office sut = new Office("BMW", 3800, "DerakhteGerdoo", "Z4", 10, 15000);

        AdminController.EditThisOfficeController(sut, "z4", 3800,
                "DerakhteGerdoo", "germany", 10, 15);

        String expected =  "germany";
        String actual = sut.getCountry();

        assertEquals(expected,actual);
    }

    @Test
    void editThisPenControllerTest() {

        Pen sut = new Pen("BMW", "GREEN", "faber", 20, 10);

        AdminController.EditThisPenController(sut, "germany", "GREEN", "faber", 20, 10);


        String expected =  "germany";
        String actual = sut.getCountry();

        assertEquals(expected,actual);
    }

    @Test
    void editThisPencilControllerTest() {

        Pencil sut = new Pencil("BMW", PencilType.HB, "abbass", 20, 10);

        AdminController.editThisPencilController(sut, "BMW", "germany", "H2", 10, 10);

        PencilType expected = PencilType.H2;
        PencilType actual = sut.getType();

        assertEquals(expected , actual);
    }
}
