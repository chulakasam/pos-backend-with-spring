package com.example.pos_backend.Dto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private String id;
    private String date;
    private double discount_value;
    private double sub_total;
    private String customer_id;
}
