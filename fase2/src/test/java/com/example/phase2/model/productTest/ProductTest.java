package com.example.phase2.model.productTest;

import com.example.phase2.model.product.ProductCategory;
import com.example.phase2.model.product.digital_Product.PC;
import com.example.phase2.model.product.digital_Product.storageDevice.FlashMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    PC sut = new PC(2000,16,"Tuf",20,"Corei7",16
    ,1000);
    @Test
    void getIDTest() {

        StringBuilder expected ;
        expected = new StringBuilder("Temp");

        //TEST FOR setID
        sut.setID(expected);

        String actual = sut.getID();

        assertEquals(expected.toString(),actual);
    }

    @Test
    void getNumberTest() {

        int expected = 1;
        int actual = sut.getNumber();

        assertEquals(expected,actual);
    }

    @Test
    void getPriceTest() {

        double expected = 1000;
        double actual = sut.getPrice();

        assertEquals(expected,actual);
    }

    @Test
    void getCategoryTest() {

        ProductCategory expected = ProductCategory.PC;
        ProductCategory actual = sut.getCategory();


        assertEquals(expected,actual);
    }

    @Test
    void getAvailableTest() {

        int expected = 20;
        int actual = sut.getAvailable();

        assertEquals(expected,actual);
    }

    @Test
    void setNameTest() {
        sut.setName("TUUUUUF");

        String expected = "TUUUUUF";

        String actual = sut.getName();

        assertEquals(expected,actual);
    }

    @Test
    void setPriceTest() {

        sut.setPrice(1);

        double expected = 1;
        double actual = sut.getPrice();

        assertEquals(expected,actual);
    }

    @Test
    void setNumberOfAvailableTest() {

        sut.setNumberOfAvailable(12);

        int expected = 12;
        int actual = sut.getAvailable();

        assertEquals(expected,actual);
    }

    @Test
    void compareToTest() {

        FlashMemory test = new FlashMemory(3,16,12,50,"A",20,200);

        int expected = -1;
        int actual = sut.compareTo(test);

        assertEquals(expected,actual);
    }

    @Test
    void getNameTest() {

        String expected = "Tuf";

        String actual = sut.getName();

        assertEquals(expected,actual);
    }
}