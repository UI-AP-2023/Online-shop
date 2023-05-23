package com.example.fase2.model.requests;

import com.example.fase2.model.userAccount.Buyer;
import com.example.fase2.model.ModelData;

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
