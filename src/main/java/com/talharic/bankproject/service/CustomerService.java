package com.talharic.bankproject.service;

import com.talharic.bankproject.converter.CustomerConverter;
import com.talharic.bankproject.converter.CustomerMapper;
import com.talharic.bankproject.dto.CustomerDto;
import com.talharic.bankproject.dto.CustomerSaveRequestDto;
import com.talharic.bankproject.dto.CustomerUpdateRequestDto;
import com.talharic.bankproject.entity.Customer;
import com.talharic.bankproject.enums.CustomerErrorMessage;
import com.talharic.bankproject.exception.ItemNotFoundException;
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

    public void delete(Long id) {

        Customer customer = customerEntityService.getByIdWithControl(id);

        customerEntityService.delete(customer);
    }

    public CustomerDto findById(Long id){

        Customer customer = customerEntityService.getByIdWithControl(id);

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);

        return customerDto;

    }

    public CustomerDto update(CustomerUpdateRequestDto customerUpdateRequestDto) {

        controlIsCustomerExist(customerUpdateRequestDto);

        Customer customer;
        customer = CustomerMapper.INSTANCE.convertToCustomer(customerUpdateRequestDto);
        customerEntityService.save(customer);

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);

        return customerDto;


    }

    private void controlIsCustomerExist(CustomerUpdateRequestDto customerUpdateRequestDto) {

        Long id = customerUpdateRequestDto.getId();
        boolean isExist = customerEntityService.existById(id);
        if(!isExist){
            throw new ItemNotFoundException(CustomerErrorMessage.CUSTOMER_ERROR_MESSAGE);
        }
    }
}
