package com.example.phase2.model.DiscountTest;

import com.example.phase2.model.Discount.Discount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    Discount sut = new Discount(50, 10, 15, "ABCD1234");

    //random discount code
    Discount rSut = new Discount(50, 10, 15);

    @Test
    void getDiscountPercentTest() {

        int expected = 50;
        int actual = sut.getDiscountPercent();

        assertEquals(expected, actual);

        //random discount code
        actual = rSut.getDiscountPercent();
        assertEquals(expected, actual);

    }

    @Test
    void getExpirationDateTest() {

        int expected = 10;
        int actual = sut.getExpirationDate();

        assertEquals(expected, actual);

        //random discount code
        actual = rSut.getDiscountPercent();
        assertEquals(expected, actual);
    }

    @Test
    void getCapacityTest() {

        int expected = 15;
        int actual = sut.getDiscountPercent();

        assertEquals(expected, actual);

        //random discount code
        actual = rSut.getDiscountPercent();
        assertEquals(expected, actual);
    }

    @Test
    void getDiscountCodeTest() {

        String expected = "ABCD1234";
        String actual = sut.getDiscountCode();

        assertEquals(expected, actual);


        int expectedLen = 7;
        int actualLen = rSut.getDiscountCode().length();

        // check that the length of the string is between 5 and 10 characters
        assertEquals(expectedLen, actualLen);

// check that the string contains only valid characters
        assertTrue(rSut.getDiscountCode().matches("^\\w{4}\\d{3}$"));
    }
}