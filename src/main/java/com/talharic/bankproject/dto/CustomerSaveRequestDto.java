package com.talharic.bankproject.dto;

import lombok.Data;

@Data
public class CustomerSaveRequestDto {

    private String name;
    private String surname;
    private Long identityNo;
    private String password;
}
