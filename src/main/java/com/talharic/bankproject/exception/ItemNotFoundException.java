package com.talharic.bankproject.exception;

import com.talharic.bankproject.enums.BaseErrorMessage;

public class ItemNotFoundException extends  RuntimeException{

    public ItemNotFoundException(BaseErrorMessage message) {
        super(message.getMessage());
    }
}
