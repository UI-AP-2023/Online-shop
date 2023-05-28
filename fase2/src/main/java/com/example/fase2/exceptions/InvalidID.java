package com.example.fase2.exceptions;

public class InvalidID extends Throwable {

    public InvalidID() {
        super("The ID is not found");
    }

    InvalidID(String message) {
        super(message);
    }
}
