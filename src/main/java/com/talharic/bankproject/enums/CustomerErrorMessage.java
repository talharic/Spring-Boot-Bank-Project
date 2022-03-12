package com.talharic.bankproject.enums;

public enum CustomerErrorMessage {

    CUSTOMER_ERROR_MESSAGE("Customer not found!"),
    ;

    private String message;
    CustomerErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
