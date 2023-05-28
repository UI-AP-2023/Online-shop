package com.example.phase2.exceptions;

public class InvalidEmailException extends Throwable {
    public InvalidEmailException(String message) {super(message);}
    public InvalidEmailException() {super("this email pattern is invalid");}
}
