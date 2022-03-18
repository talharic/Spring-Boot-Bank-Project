package com.talharic.bankproject.entity;

import com.talharic.bankproject.enums.MoneyTransferType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MONEY_TRANSFER")
@Setter
@Getter
public class MoneyTransfer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ACCOUNT_FROM")
    private Long accountIdFrom;

    @Column(name = "ID_ACCOUNT_TO")
    private Long accountIdTo;

    @Column(name = "AMOUNT", precision = 19, scale = 2)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSFER_DATE")
    private Date transferDate;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSFER_TYPE", length = 30)
    private MoneyTransferType transferType;
}
