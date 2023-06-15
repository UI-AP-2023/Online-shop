package com.example.fase2.exceptions;

public class InvalidLoginException extends Throwable {

    public InvalidLoginException(){
        super("Invalid login parameters");
    }
}
