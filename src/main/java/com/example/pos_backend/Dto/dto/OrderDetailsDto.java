package com.example.pos_backend.Dto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsDto {
    private String detailsId;
    private OrderDto order;
    private ItemDto item;
    private int orderQty;
    private double unitPrice;
}
