package com.talharic.bankproject.service;

import com.talharic.bankproject.converter.CustomerConverter;
import com.talharic.bankproject.converter.CustomerMapper;
import com.talharic.bankproject.dto.CustomerDto;
import com.talharic.bankproject.dto.CustomerSaveRequestDto;
import com.talharic.bankproject.entity.Customer;
import com.talharic.bankproject.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerEntityService customerEntityService;
    private final CustomerConverter customerConverter;

    public List<CustomerDto> findAll() {

        List<Customer> customerList = customerEntityService.findAll();

        List<CustomerDto> customerDtoList = customerConverter.convertToCustomerDtoList(customerList);

        return customerDtoList;
    }

    public CustomerDto save(CustomerSaveRequestDto customerSaveRequestDto) {

        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerSaveRequestDto);

        customer = customerEntityService.save(customer);

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);

        return customerDto;
    }
}
