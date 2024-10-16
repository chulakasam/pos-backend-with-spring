package com.example.pos_backend.service.impl;

import com.example.pos_backend.Dao.CustomerDao;
import com.example.pos_backend.Dao.OrderDao;
import com.example.pos_backend.Dto.dto.OrderDetailsDto;
import com.example.pos_backend.Dto.dto.OrderDto;
import com.example.pos_backend.Entity.OrderEntity;
import com.example.pos_backend.exceotion.DataPersistException;
import com.example.pos_backend.service.OrderDetailsService;
import com.example.pos_backend.service.OrderService;
import com.example.pos_backend.util.AppUtil;
import com.example.pos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    OrderDetailsService orderDetailsService;

    @Override
    public void saveOrder(OrderDto orderDto) {
        OrderEntity save_Order = orderDao.save(mapping.toOrderEntity(orderDto));
        if(save_Order==null){
            throw new DataPersistException("Order not saved !!!");
        }else {

        }
    }
}
