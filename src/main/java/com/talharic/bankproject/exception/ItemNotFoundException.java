package com.talharic.bankproject.exception;

import com.talharic.bankproject.enums.CustomerErrorMessage;

public class ItemNotFoundException extends  RuntimeException{

    public ItemNotFoundException(CustomerErrorMessage message) {
        super(message.getMessage());
    }
}
