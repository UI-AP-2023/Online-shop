package com.example.phase2.exceptions;

public class InvalidPasswordException extends Throwable {
    public InvalidPasswordException(String message) {super(message);}
    public InvalidPasswordException(){super("this password pattern is invalid");}
}
