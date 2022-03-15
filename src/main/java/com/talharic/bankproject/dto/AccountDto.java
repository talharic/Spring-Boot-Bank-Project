package com.talharic.bankproject.dto;

import com.talharic.bankproject.enums.AccountType;
import com.talharic.bankproject.enums.CurrencyType;
import com.talharic.bankproject.enums.StatusType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Long customerId;
    private String ibanNo;
    private BigDecimal currentBalance;
    private CurrencyType currencyType;
    private AccountType accountType;
    private StatusType statusType;
}
