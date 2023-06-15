package com.example.phase2.model.scoreTest;

import com.example.phase2.model.invoice_comment_score.Score;
import com.example.phase2.model.userAccount.Buyer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    Buyer testBuyer = new Buyer("Abbass", "Abbass", "09133287220", "abbass@gmail.com");
    
    Score sut = new Score(testBuyer,5);

    @Test
    void getScoreTest(){

        int expected = 5;
        int actual = sut.getScore();

        assertEquals(expected, actual);
    }
}