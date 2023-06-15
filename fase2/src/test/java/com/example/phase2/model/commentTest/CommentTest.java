package com.example.phase2.model.commentTest;

import com.example.phase2.model.invoice_comment_score.Comment;
import com.example.phase2.model.product.Product;
import com.example.phase2.model.product.digital_Product.storageDevice.SSD;
import com.example.phase2.model.userAccount.Buyer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    Buyer buyer = new Buyer("Abbass", "Abbass", "09133287220", "abbass@gmail.com");
    SSD ssd = new SSD(1000, 2000, 2000, 20, 20,
            "Abbass SSD", 12, 120);
    Comment sut = new Comment(buyer, "I am abbass", ssd, false);

    @Test
    void getProductTest() {

        Product expected = ssd;
        Product actual = sut.getProduct();

        assertEquals(expected, actual);
    }

    @Test
    void getCommentTest() {

        String expected = "I am abbass";
        String actual = sut.getComment();

        assertEquals(expected,actual);

    }

    @Test
    void getCustomerTest() {

        Buyer expected = buyer;
        Buyer actual = sut.getCommenter();

        assertEquals(expected,actual);
    }

    @Test
    void getBoughtByCommenterTest() {

        assertFalse(sut.getBoughtByCommenter());
    }
}