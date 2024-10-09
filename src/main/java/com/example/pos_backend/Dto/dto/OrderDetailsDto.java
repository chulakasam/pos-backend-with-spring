package com.example.pos_backend.Dto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsDto {
    private String order_id;
    private String item_id;
    private int qty;
    private double unitPrice;
    private double total;

}
