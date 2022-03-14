package com.talharic.bankproject.dto;

import com.talharic.bankproject.enums.MoneyTransferType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MoneyTransferSaveRequestDto {

    private Long accountIdFrom;
    private Long accountIdTo;
    private BigDecimal amount;
    private String description;
    private MoneyTransferType transferType;
}
