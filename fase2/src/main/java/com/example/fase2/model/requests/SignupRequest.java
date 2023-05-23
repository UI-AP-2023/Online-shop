package com.example.fase2.model.requests;


import com.example.fase2.model.userAccount.Buyer;

public class SignupRequest {

    Buyer requester;

    private static int staticNumber=1;
    private final int number;

    //==================================================================================================================


    public SignupRequest(Buyer requester){

        this.requester=requester;
        this.number = staticNumber++;
    }

    //------------------------------------------------------
    @Override
    public String toString() {
        return number + requester.toString();
    }
}
