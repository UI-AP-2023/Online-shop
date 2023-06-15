package com.example.phase2.model.loginTest;

import com.example.fase2.exceptions.InvalidLoginException;
import com.example.phase2.controller.LoginPageController;
import com.example.phase2.exceptions.InvalidEmailException;
import com.example.phase2.exceptions.InvalidPasswordException;
import com.example.phase2.exceptions.InvalidPhoneNumberException;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.userAccount.Buyer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageControllerTest {

    @Test
    void loginCheckTest() {

        ModelData.addCustomer(new Buyer("m","m","09","m@"));

        try {
            LoginPageController.loginCheck("m","m");
        } catch (InvalidLoginException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        try {
            LoginPageController.loginCheck("Abbbbass","p");
            fail("Expected InvalidLoginException to be thrown");
        } catch (InvalidLoginException e) {
            assertNotNull(e);
        }
    }

    @Test
    void emailCheckTest() {

        try {
            LoginPageController.emailCheck("mahdi@gmail.com");
        } catch (InvalidEmailException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        try {
            LoginPageController.emailCheck("Abbbbass p");
            fail("Expected InvalidLoginException to be thrown");
        } catch (InvalidEmailException e) {
            assertNotNull(e);
        }
    }

    @Test
    void phoneNumberCheckTest() {

        try {
            LoginPageController.phoneNumberCheck("09133287220");
        } catch (InvalidPhoneNumberException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        try {
            LoginPageController.phoneNumberCheck("Abbbbass p");
            fail("Expected InvalidLoginException to be thrown");
        } catch (InvalidPhoneNumberException e) {
            assertNotNull(e);
        }
    }

    @Test
    void passwordCheckTest() {

        try {
            LoginPageController.passwordCheck("Ma1383!@#$");
        } catch (InvalidPasswordException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        try {
            LoginPageController.passwordCheck("Abbbbass p");
            fail("Expected InvalidLoginException to be thrown");
        } catch (InvalidPasswordException e) {
            assertNotNull(e);
        }
    }
}