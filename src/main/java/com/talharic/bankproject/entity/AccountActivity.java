package com.talharic.bankproject.entity;

import com.talharic.bankproject.enums.AccountActivityType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT_ACTIVITY")
@Getter
@Setter
public class AccountActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ACCOUNT")
    private Long accountId;

    @Column(name = "AMOUNT", scale = 2, precision = 19)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;

    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 2)
    private BigDecimal currentBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_ACTIVITY_TYPE", length = 30)
    private AccountActivityType accountActivityType;
}
