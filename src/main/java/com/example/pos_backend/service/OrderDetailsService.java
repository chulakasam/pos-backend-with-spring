package com.example.pos_backend.service;

import com.example.pos_backend.Dto.dto.OrderDetailsDto;

public interface OrderDetailsService {
    void saveOrderDetail(OrderDetailsDto orderDetailDTO);
}
