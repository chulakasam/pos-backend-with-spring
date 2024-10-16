package com.example.pos_backend.service.impl;

import com.example.pos_backend.Dto.dto.OrderDetailsDto;
import com.example.pos_backend.service.OrderDetailsService;
import com.example.pos_backend.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
    //TODO : save order details(transaction)
    @Override
    public void saveOrderDetail(OrderDetailsDto orderDetailDTO) {

    }
}
