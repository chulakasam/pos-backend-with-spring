package com.example.pos_backend.controller;

import com.example.pos_backend.Dto.dto.CustomerDto;
import com.example.pos_backend.Dto.status.CustomerStatus;
import com.example.pos_backend.customStatusCodes.SelectedUserErrorStatus;
import com.example.pos_backend.exceotion.DataPersistException;
import com.example.pos_backend.exceotion.UserNotFoundException;
import com.example.pos_backend.service.CustomerService;
import com.example.pos_backend.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

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
    )
    {
        try{
            CustomerDto customerDto = new CustomerDto();
            customerDto.setCustomerId(nic);
            customerDto.setAddress(address);
            customerDto.setName(name);
            customerDto.setRegDate(date);
            customerDto.setTel(tel);
            customerService.saveCustomer(customerDto);
            logger.info("customer saved successfully !!!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
        logger.info("update successfully !!!");
    }
//------TO DO-------------customer delete
    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") String customerId){
        String regexForUserID = "^(\\d{9}[VXvx]|\\d{12})$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(customerId);

         try{
             if (!regexMatcher.matches()){
                 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
             }
             customerService.deleteCustomer(customerId);
             logger.info("customer delete successfully !!!");
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }catch (UserNotFoundException e){
             logger.warn("404 Not Found Status",e.getMessage());
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }catch (Exception e){
             logger.error("delete unsuccessfully !!!");
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
//------TO DO-------------customer getAll
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllUsers();
    }

//------TO DO-------------customer get by ID
    @GetMapping(value="/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus getSelectedCustomer(@PathVariable("customerId") String customerId){
        String regexForUserID = "^(\\d{9}[VXvx]|\\d{12})$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(customerId);

        if(!regexMatcher.matches()){
            logger.error("Http 400 Bad Request!!!");
            return new SelectedUserErrorStatus(1,"user id invalid");
        }
        return customerService.getCustomerById(customerId);
    }



}
