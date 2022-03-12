package com.talharic.bankproject.service.entityservice;

import com.talharic.bankproject.entity.Customer;
import com.talharic.bankproject.enums.CustomerErrorMessage;
import com.talharic.bankproject.exception.ItemNotFoundException;
import com.talharic.bankproject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerEntityService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public void delete(Customer customer){
        customerRepository.delete(customer);
    }

    public Customer getByIdWithControl(Long id) {

        Optional<Customer> customerOptional = findById(id);

        Customer customer;
        if(customerOptional.isPresent()){
            customer = customerOptional.get();
        }else{
            throw new ItemNotFoundException(CustomerErrorMessage.CUSTOMER_ERROR_MESSAGE);
        }
        return customer;
    }

    public boolean existById(Long id){
        return customerRepository.existsById(id);
    }
}