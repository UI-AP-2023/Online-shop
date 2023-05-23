package model.requests;

import model.ModelData;
import model.userAccount.Buyer;

public class IncrementBalanceRequest {

    private final Buyer requester;
    private final double amount;

    public IncrementBalanceRequest(Buyer requester, double amount) {

        this.requester = requester;
        this.amount = amount;

        ModelData.getIncrementBalanceRequests().add(this);
    }

    //--------------------------------------------------------------------

    @Override
    public String toString() {
        return requester.toString() + " , AMOUNT: "+ amount;
    }
}
