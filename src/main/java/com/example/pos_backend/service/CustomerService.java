package com.example.pos_backend.service;

import com.example.pos_backend.Dto.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(String customerId);

    boolean updateCustomer(String customerId,CustomerDto customerDto);

    void deleteCustomer(String customerId);

    List<CustomerDto> getAllUsers();
}
