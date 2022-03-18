package com.talharic.bankproject.enums;

public enum AccountErrorMessage implements BaseErrorMessage{

    INSUFFICIENT_BALANCE("Insufficient balance!"),
    ;

    private String message;
    AccountErrorMessage(String message){
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
