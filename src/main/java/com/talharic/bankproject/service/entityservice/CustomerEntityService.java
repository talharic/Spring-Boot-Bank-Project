package com.talharic.bankproject.service.entityservice;

import com.talharic.bankproject.entity.Customer;
import com.talharic.bankproject.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository>{

    public CustomerEntityService(CustomerRepository repository) {
        super(repository);
    }
}