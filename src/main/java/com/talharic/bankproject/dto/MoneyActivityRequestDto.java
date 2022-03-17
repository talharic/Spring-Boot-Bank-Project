package com.talharic.bankproject.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MoneyActivityRequestDto {

    private Long accountId;
    private BigDecimal amount;
}
