package model.requests;

import model.userAccount.Buyer;

public class IncrementBalanceRequest {

    private final Buyer requester;
    private final double amount;

    IncrementBalanceRequest(Buyer requester, double amount) {

        this.requester = requester;
        this.amount = amount;
    }

    //--------------------------------------------------------------------

    @Override
    public String toString() {
        return requester.toString() + " , AMOUNT: "+ amount;
    }
}
