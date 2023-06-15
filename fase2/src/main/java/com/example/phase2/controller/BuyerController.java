package com.example.phase2.controller;


import com.example.phase2.exceptions.InUsedUserNameException;
import com.example.phase2.exceptions.InvalidProductNumber;
import com.example.phase2.model.Discount.Discount;
import com.example.phase2.model.ModelData;
import com.example.phase2.model.invoice_comment_score.Comment;
import com.example.phase2.model.invoice_comment_score.Invoice;
import com.example.phase2.model.product.Product;
import com.example.phase2.model.userAccount.Buyer;
import com.example.phase2.view.BuyerView.BuyerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public interface BuyerController {

    //---------------------------------------------------------------------
    static String getMyProfile() {
        return "User name: " + ModelData.getYou().getUserName() + "\nPassword: " + ModelData.getYou().getPassword()
                + "\nEmail: " + ModelData.getYou().getEmail() + "\nPhone number: " + ModelData.getYou().getPhoneNumber()
                + "\nBalance: " + ModelData.getYou().getBalance();
    }
    //---------------------------------------------------------------------

    static void checkUserName(String userName) throws InUsedUserNameException {

        for (Buyer customer : ModelData.getCustomers()) {

            if (Objects.equals(customer.getUserName(), userName)) {
                throw new InUsedUserNameException();
            }
        }
    }

    //------------------------------------------------------------------------

    static void setUserName(String userName) {

        ModelData.getYou().setUserName(userName);
    }

    static void setPassword(String password) {

        ModelData.getYou().setPassword(password);
    }

    static void setEmail(String email) {

        ModelData.getYou().setEmail(email);
    }

    static void setPhoneNumber(String phoneNumber) {

        ModelData.getYou().setPhoneNumber(phoneNumber);
    }

    //------------------------------------------------------------------------------

    static void setIncrementBalanceRequest(double amount) {

        double pool = ModelData.getYou().getBalance();
        pool += amount;
        ModelData.getYou().setBalance(pool);
    }


    //-----------------------------------------------------------------------


    static String getMyBuyingCart() {

        StringBuilder temp = new StringBuilder();

        for (Product product : ModelData.getYou().getProductsCart()) {
            temp.append(product.toString()).append("\n");
        }

        return temp.toString();
    }

    //---------------------------------------------------------------------------


    static ArrayList<Invoice> getInvoice() {
        return ModelData.getYou().getInvoices();
    }

    //-----------------------------------------------------------------------

    static ArrayList<Product> getProducts() {
        return ModelData.getProducts();
    }

    //--------------------------------------------------

    static Product getThisProduct(int numberOfProduct) {

        for (Product product : ModelData.getProducts()) {
            if (product.getNumber() == numberOfProduct) {
                return product;
            }
        }
        throw new NullPointerException();
    }

    static boolean checkNumberForBuying(Product product, int numberOfProductsYouWant) {

        return numberOfProductsYouWant <= product.getAvailable();

    }

    static void addProductToCart(Product product, int numberOfProductsYouWant) {

        for (int i = 0; i < numberOfProductsYouWant; i++) {

            ModelData.getYou().addProduct(product);
        }
    }

//--------------------------------------------------------------------------------

    static void addComment(String commentText, Product product) {

        Comment comment;
        if (BuyerController.checkBoughtThisProduct(product)) {
            comment = new Comment(ModelData.getYou(), commentText, product, true);
        } else {
            comment = new Comment(ModelData.getYou(), commentText, product, false);
        }

        product.AddComment(comment);
    }

    //---------------------------------------------------------------------------------

    static boolean checkBoughtThisProduct(Product product) {

        for (Invoice invoice : ModelData.getYou().getInvoices()) {
            for (Product TempProduct : invoice.getBoughtOrders()) {

                if (Objects.equals(TempProduct, product)) {
                    return true;
                }
            }
        }
        return false;
    }

    //--------------------------------------------------------------------

    static boolean checkScore(int score) {
        return score <= 5 && score >= 1;
    }

    //----------------------------------------------------------------------------

    static void addScore(Product product, int score) {

        product.getBuyersScores().add(score);
    }

    //---------------------------------------------------------------------------
    static void buyThisCart(String code) {

        int discountPercent = 0;

        if (!Objects.equals(code, "")) {

            boolean found = false;

            for (Discount discount : ModelData.getDiscountCodes()) {

                if (Objects.equals(discount.getDiscountCode(), code)) {

                    discountPercent = discount.getDiscountPercent();
                    found = true;
                }
            }

            if (!found) {
                BuyerView.discountCodeNotFound();
                return;
            }
        }


        double amount = calculateAmount();

        amount -= amount * discountPercent / 100;

        double before = ModelData.getYou().getBalance();

        if (before >= amount) {

            double after = before - amount;

            LocalDate now = LocalDate.now();

            ModelData.getYou().getInvoices().add(new Invoice(now.toString(), amount, ModelData.getYou().getProductsCart()));

            ModelData.getYou().setBalance(after);

            for (Product p : ModelData.getYou().getProductsCart()) {

                int temp = p.getAvailable();

                temp--;

                p.setNumberOfAvailable(temp);
            }

            ModelData.getYou().getProductsCart().clear();

            BuyerView.printThanksForShopping();
        } else
            BuyerView.printNotEnoughBalance();
    }

    //----------------------------------------------------

    static double calculateAmount() {

        double sum = 0;

        for (Product product : ModelData.getYou().getProductsCart()) {
            sum += product.getPrice();
        }

        return sum;
    }

    //--------------------------------------------------------------------------
    static void removeThisFromCart(int number) throws InvalidProductNumber {


        for (Product product : ModelData.getYou().getProductsCart()) {
            if (product.getNumber() == number) {
                ModelData.getYou().getProductsCart().remove(product);
                return;
            }
        }
        throw new InvalidProductNumber();
    }

    //-----------------------------------------------------------------------


}

