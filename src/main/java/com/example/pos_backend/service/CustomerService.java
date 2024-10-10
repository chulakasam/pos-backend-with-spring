package com.example.pos_backend.service;

import com.example.pos_backend.Dto.dto.CustomerDto;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(String customerId);

    boolean updateCustomer(String customerId,CustomerDto customerDto);
}
