package com.talharic.bankproject.converter;

import com.talharic.bankproject.dto.CustomerDto;
import com.talharic.bankproject.dto.CustomerSaveRequestDto;
import com.talharic.bankproject.dto.CustomerUpdateRequestDto;
import com.talharic.bankproject.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy =  ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer convertToCustomer(CustomerSaveRequestDto customerSaveRequestDto);

    Customer convertToCustomer(CustomerUpdateRequestDto customerUpdateRequestDto);

    List<CustomerDto> convertToCustomerDtoList(List<Customer> customerList);

    CustomerDto convertToCustomerDto(Customer customer);
}
