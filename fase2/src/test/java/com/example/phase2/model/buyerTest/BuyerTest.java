package com.example.phase2.model.buyerTest;

import com.example.phase2.model.userAccount.Buyer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BuyerTest {

    Buyer sut = new Buyer("m","m","09999999999","m@gmail.com");
    @Test
    void getBalanceTest() {

        sut.setBalance(2000);

        double expectedBalance = 2000;
        double actualBalance = sut.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    void setBalanceTest() {

//        sut.setBalance(0);

        sut.setBalance(2000);

        double expectedBalance = 2000;
        double actualBalance = sut.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }
}