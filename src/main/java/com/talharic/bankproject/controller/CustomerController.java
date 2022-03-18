package com.talharic.bankproject.controller;

import com.talharic.bankproject.dto.CustomerDto;
import com.talharic.bankproject.dto.CustomerSaveRequestDto;
import com.talharic.bankproject.dto.CustomerUpdateRequestDto;
import com.talharic.bankproject.dto.RestResponse;
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

        return ResponseEntity.ok(RestResponse.of(customerDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        CustomerDto customerDto = customerService.findById(id);

        return ResponseEntity.ok(RestResponse.of(customerDto));

    }

    @PostMapping
    public ResponseEntity save(@RequestBody CustomerSaveRequestDto customerSaveRequestDto){

        CustomerDto customerDto = customerService.save(customerSaveRequestDto);

        return new ResponseEntity(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        customerService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto){

        CustomerDto customerDto = customerService.update(customerUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(customerDto));
    }
}
