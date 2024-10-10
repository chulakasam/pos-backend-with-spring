package com.example.pos_backend.service.impl;

import com.example.pos_backend.Dao.CustomerDao;
import com.example.pos_backend.Dto.dto.CustomerDto;
import com.example.pos_backend.Entity.CustomerEntity;
import com.example.pos_backend.exceotion.DataPersistException;
import com.example.pos_backend.exceotion.UserNotFoundException;
import com.example.pos_backend.service.CustomerService;
import com.example.pos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
            throw new DataPersistException("customer not saved");
        }
    }

    @Override
    public CustomerDto getCustomerById(String customerId) {
        CustomerEntity referenceById = customerDao.getReferenceById(customerId);
       return customerMapping.toUserDTO(referenceById);
    }

    @Override
    public boolean updateCustomer(String customerId, CustomerDto customerDto) {
        Optional<CustomerEntity> tmp_customer = customerDao.findById(customerId);
        if(tmp_customer.isPresent()){
           tmp_customer.get().setAddress(customerDto.getAddress());
           tmp_customer.get().setName(customerDto.getName());
           tmp_customer.get().setRegDate(customerDto.getRegDate());
           tmp_customer.get().setTel(customerDto.getTel());
        }
        return false;
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> select_customer = customerDao.findById(customerId);
        if(!select_customer.isPresent()){
            throw new UserNotFoundException("Customer with NIC " + customerId + " not found");
        }else{
            customerDao.deleteById(customerId);
        }
    }
}
