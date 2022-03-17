package com.talharic.bankproject.dto;

import com.talharic.bankproject.enums.MoneyTransferType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MoneyTransferDto {

    private Long accountIdFrom;
    private Long accountIdTo;
    private BigDecimal amount;
    private Date transferDate;
    private String description;
    private MoneyTransferType transferType;
}
