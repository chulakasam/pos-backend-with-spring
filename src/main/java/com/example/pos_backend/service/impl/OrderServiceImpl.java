package com.example.pos_backend.service.impl;

import com.example.pos_backend.Dao.CustomerDao;
import com.example.pos_backend.Dao.ItemDao;
import com.example.pos_backend.Dao.OrderDao;
import com.example.pos_backend.Dao.OrderDetailsDao;
import com.example.pos_backend.Dto.dto.OrderDetailsDto;
import com.example.pos_backend.Dto.dto.OrderDto;
import com.example.pos_backend.Entity.ItemEntity;
import com.example.pos_backend.Entity.OrderDetailsEntity;
import com.example.pos_backend.Entity.OrderEntity;
import com.example.pos_backend.exceotion.DataPersistException;
import com.example.pos_backend.service.OrderDetailsService;
import com.example.pos_backend.service.OrderService;
import com.example.pos_backend.util.AppUtil;
import com.example.pos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;


    @Override
    public void saveOrder(OrderDto orderDTO, List<OrderDetailsDto> orderDetailsDTOS) {
        orderDTO.setOrderId(AppUtil.generateOrderId());
        OrderEntity save_order = orderDao.save(mapping.toOrderEntity(orderDTO));

        if(save_order==null){
            throw new DataPersistException("Order not saved !!!");
        }
        for(OrderDetailsDto orderDetailsDto:orderDetailsDTOS){
            orderDetailsDto.setDetailsId(AppUtil.generateOrderDetailsId());
            OrderDetailsEntity orderDetailsEntity = mapping.toOrderDetailsEntity(orderDetailsDto);
            orderDetailsEntity.setOrder(save_order);
            orderDetailsDao.save(orderDetailsEntity);

            Optional<ItemEntity> choose_item = itemDao.findById(String.valueOf(orderDetailsDto.getOrderQty()));

            if(choose_item.isPresent()){
                ItemEntity itemEntity = choose_item.get();
                int update_Qty = itemEntity.getQty() - orderDetailsDto.getOrderQty();
                if (update_Qty<=0) {
                    throw new DataPersistException("Item is out of stock :"+ orderDetailsDto.getItem());
                }
                itemEntity.setQty(update_Qty);
                itemDao.save(itemEntity);
            }

        }
    }
}
