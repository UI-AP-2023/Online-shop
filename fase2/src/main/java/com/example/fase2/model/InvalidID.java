package com.example.fase2.model;

public class InvalidID extends Throwable {

    public InvalidID() {
        super("The ID is not found");
    }

    InvalidID(String message) {
        super(message);
    }
}
