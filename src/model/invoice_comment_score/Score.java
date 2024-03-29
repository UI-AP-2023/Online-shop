package model.invoice_comment_score;

import model.userAccount.Buyer;

public class Score {

    private final Buyer buyer;
    private final int score;

    //========================

    Score(Buyer buyer, int score) {

        this.buyer = buyer;
        this.score = score;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public int getScore() {
        return score;
    }
}
