package com.example.RestApiApp.util;

public class ObjectIsAlreadyUsedException extends RuntimeException {
    public ObjectIsAlreadyUsedException(String msg) {
        super(msg); }
}
