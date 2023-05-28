package com.example.fase2.exceptions;

public class InUsedUserNameException extends Throwable {

    public InUsedUserNameException(String message){
        super(message);
    }

    public InUsedUserNameException(){
        super("The user name already exist");
    }
}
