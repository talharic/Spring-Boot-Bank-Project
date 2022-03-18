package com.talharic.bankproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "IDENTITY_NO", nullable = false)
    private Long identityNo;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}
