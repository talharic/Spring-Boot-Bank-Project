package com.talharic.bankproject.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MoneyWithdrawRequestDto {

    private Long accountId;
    private BigDecimal amount;

}
