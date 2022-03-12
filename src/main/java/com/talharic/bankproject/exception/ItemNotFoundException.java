package com.talharic.bankproject.exception;

public class ItemNotFoundException extends  RuntimeException{

    public ItemNotFoundException(String message) {
        super(message);
    }
}
