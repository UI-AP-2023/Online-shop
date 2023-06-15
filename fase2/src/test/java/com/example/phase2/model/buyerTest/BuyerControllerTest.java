package com.example.phase2.model.buyerTest;

import com.example.phase2.controller.BuyerController;
import com.example.phase2.exceptions.InUsedUserNameException;
import com.example.phase2.exceptions.InvalidProductNumber;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.product.Product;
import com.example.phase2.model.product.stationerySupplies.Pen;
import com.example.phase2.model.userAccount.Buyer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyerControllerTest {

    Buyer sut = new Buyer("m", "m", "09", "m");

    @Test
    void checkUserNameTest() {

        ModelData.addCustomer(sut);

        try {
            BuyerController.checkUserName("abbass");
        } catch (InUsedUserNameException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        try {
            BuyerController.checkUserName("m");
            fail("Expected InvalidPasswordException to be thrown");
        } catch (InUsedUserNameException e) {
            assertNotNull(e);
        }
    }

    @Test
    void setUserNameTest() {

        ModelData.setYou(sut);

        BuyerController.setUserName("Ali");

        String expected = "Ali";
        String actual = sut.getUserName();

        assertEquals(expected, actual);
    }

    @Test
    void setPasswordTest() {
        ModelData.setYou(sut);

        BuyerController.setPassword("Ali");

        String expected = "Ali";
        String actual = sut.getPassword();

        assertEquals(expected, actual);
    }

    @Test
    void setEmailTest() {

        ModelData.setYou(sut);

        BuyerController.setEmail("Ali");

        String expected = "Ali";
        String actual = sut.getEmail();

        assertEquals(expected, actual);
    }

    @Test
    void setPhoneNumberTest() {

        ModelData.setYou(sut);

        BuyerController.setPhoneNumber("Ali");

        String expected = "Ali";
        String actual = sut.getPhoneNumber();


        assertEquals(expected, actual);
    }

    @Test
    void addProductToCartTest() {

        Pen pen = new Pen("Germany", "Green", "name", 20, 200);

        ModelData.setYou(sut);

        BuyerController.addProductToCart(pen, 1);


        boolean found = false;
        for (Product p : sut.getProductsCart()) {

            if (p == pen) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }

    @Test
    void checkBoughtThisProductTest() {

        Pen pen = new Pen("Germany", "Green", "name", 20, 200);

        ModelData.setYou(sut);

        assertFalse(BuyerController.checkBoughtThisProduct(pen));
    }

    @Test
    void checkScoreTest() {

        assertTrue(BuyerController.checkScore(3));
    }

    @Test
    void calculateAmountTest() {

        Pen pen = new Pen("Germany", "Green", "name", 20, 200);

        ModelData.setYou(sut);

        BuyerController.addProductToCart(pen, 1);

        double expected = 200;
        double actual = BuyerController.calculateAmount();

        assertEquals(expected,actual);
    }

    @Test
    void removeThisFromCartTest() throws InvalidProductNumber {

        Pen pen = new Pen("Germany", "Green", "name", 20, 200);

        ModelData.setYou(sut);

        BuyerController.addProductToCart(pen, 1);
        BuyerController.removeThisFromCart(pen.getNumber());

        boolean found = true;

        for (Product p : sut.getProductsCart()) {
            if (p == pen) {
                found = false;
                break;
            }
        }

        assertTrue(found);
    }
}