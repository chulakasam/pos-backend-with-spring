package com.example.pos_backend.Dto.dto;


import com.example.pos_backend.Dto.status.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto implements CustomerStatus {
    private String customerId;
    private String name;
    private String address;
    private String tel;
    private String regDate;

}
