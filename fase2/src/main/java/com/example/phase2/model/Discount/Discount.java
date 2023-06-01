package com.example.phase2.model.Discount;

import java.time.LocalDate;
import java.util.Random;

public class Discount {

    private final int discountPercent;
    private final int expirationDate;
    private final int capacity;
    private final String discountCode;

    public Discount(int discountPercent, int date, int capacity, String discountCode) {

        this.discountPercent = discountPercent;
        this.expirationDate = date;
        this.capacity = capacity;
        this.discountCode = discountCode;
    }

    public Discount(int discountPercent, int date, int capacity) {

        this.discountPercent = discountPercent;
        this.expirationDate = date;
        this.capacity = capacity;

        String randomChars = getRandomChars();
        String randomNums = getRandomNums();
        this.discountCode = randomChars + randomNums;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDiscountCode() {
        return discountCode;
    }


    //--------------------------------{
    private static final Random rnd = new Random();
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static char getRandomChar() {
        int index = (int) (rnd.nextFloat() * CHARACTERS.length());
        return CHARACTERS.charAt(index);
    }

    private static String getRandomChars() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(getRandomChar());
        }
        return sb.toString();
    }

    private static String getRandomNums() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(rnd.nextInt(10));
        }
        return sb.toString();
    }

    //-------------------------------}
}
