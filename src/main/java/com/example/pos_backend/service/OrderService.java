package com.example.pos_backend.service;

import com.example.pos_backend.Dto.dto.OrderDetailsDto;
import com.example.pos_backend.Dto.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDto orderDTO, List<OrderDetailsDto> orderDetailsDTOS);
}
