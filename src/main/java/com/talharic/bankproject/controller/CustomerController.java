package com.talharic.bankproject.controller;

import com.talharic.bankproject.dto.CustomerDto;
import com.talharic.bankproject.dto.CustomerSaveRequestDto;
import com.talharic.bankproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity findAll(){

        List<CustomerDto> customerDtoList = customerService.findAll();

        return new ResponseEntity(customerDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CustomerSaveRequestDto customerSaveRequestDto){

        CustomerDto customerDto = customerService.save(customerSaveRequestDto);

        return new ResponseEntity(customerDto, HttpStatus.OK);
    }
}
