package com.example.pos_backend.controller;

import com.example.pos_backend.Dto.dto.CustomerDto;
import com.example.pos_backend.service.CustomerService;
import com.example.pos_backend.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private static Logger logger= LoggerFactory.getLogger(CustomerController.class);
    //------TO DO-------------customer save
    @PostMapping( consumes= MediaType.MULTIPART_FORM_DATA_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(
            @RequestPart("nic") String nic,
            @RequestPart("address") String address,
            @RequestPart("name") String name,
            @RequestPart("regDate") String date,
            @RequestPart("tel") String tel
    ){

        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(nic);
        customerDto.setAddress(address);
        customerDto.setName(name);
        customerDto.setRegDate(date);
        customerDto.setTel(tel);
        customerService.saveCustomer(customerDto);
        logger.info("customer saved successfully !!!");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
   //------TO DO-------------customer update
    @PutMapping(value = "/{customerId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateCustomer(
        @RequestPart("address") String address,
        @RequestPart("name") String name,
        @RequestPart("regDate") String date,
        @RequestPart("tel") String tel,
        @PathVariable("customerId") String customerId)
    {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customerId);
        customerDto.setAddress(address);
        customerDto.setName(name);
        customerDto.setRegDate(date);
        customerDto.setTel(tel);
        customerService.updateCustomer(customerId,customerDto);
    }
//------TO DO-------------customer delete
    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") String customerId){
         customerService.deleteCustomer(customerId);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//------TO DO-------------customer getAll

//------TO DO-------------customer get by ID
    @GetMapping(value="/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto getSelectedCustomer(@PathVariable("customerId") String customerId){
              return customerService.getCustomerById(customerId);
    }



}
