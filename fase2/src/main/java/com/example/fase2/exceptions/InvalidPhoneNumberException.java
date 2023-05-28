package com.example.fase2.exceptions;

public class InvalidPhoneNumberException extends Throwable {
public InvalidPhoneNumberException(String message) {
    super(message);
}
public InvalidPhoneNumberException(){
    super("this phone number pattern is in valid");
}
}
