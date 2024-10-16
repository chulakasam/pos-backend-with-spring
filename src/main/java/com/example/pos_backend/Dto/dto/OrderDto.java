package com.example.pos_backend.Dto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private String orderId;
    private String customerId;
    private LocalDate orderDate;
    private List<OrderDetailsDto> orderDetails;
}
