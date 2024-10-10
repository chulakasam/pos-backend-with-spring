package com.example.pos_backend.service.impl;

import com.example.pos_backend.Dao.CustomerDao;
import com.example.pos_backend.Dto.dto.CustomerDto;
import com.example.pos_backend.Entity.CustomerEntity;
import com.example.pos_backend.exceotion.DataPersistException;
import com.example.pos_backend.service.CustomerService;
import com.example.pos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping customerMapping;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        CustomerEntity save_customer = customerDao.save(customerMapping.toUserEntity(customerDto));
        if(save_customer==null){
            throw new DataPersistException("customer not found");
        }
    }
}
