package com.example.pos_backend.service;

import com.example.pos_backend.Dto.dto.OrderDto;

public interface OrderService {
    void saveOrder(OrderDto orderDto);
}
