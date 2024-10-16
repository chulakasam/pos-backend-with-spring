package com.example.pos_backend.util;

import com.example.pos_backend.Dto.dto.CustomerDto;
import com.example.pos_backend.Dto.dto.ItemDto;
import com.example.pos_backend.Dto.dto.OrderDetailsDto;
import com.example.pos_backend.Dto.dto.OrderDto;
import com.example.pos_backend.Entity.CustomerEntity;
import com.example.pos_backend.Entity.ItemEntity;
import com.example.pos_backend.Entity.OrderDetailsEntity;
import com.example.pos_backend.Entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    public CustomerEntity toUserEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
    public CustomerDto toUserDTO(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    public List<CustomerDto> asUserDTOList(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDto>>(){}.getType());
    }
    public ItemDto toItemDto(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDto.class);
    }
    public ItemEntity toItemEntity(ItemDto itemDto){
        return modelMapper.map(itemDto,ItemEntity.class);
    }
    public List<ItemDto> asItemDtoList(List<ItemEntity>itemEntities){
        return modelMapper.map(itemEntities, new TypeToken<List<ItemDto>>() {}.getType());
    }

    public OrderEntity toOrderEntity(OrderDto orderDto) {
        return modelMapper.map(orderDto, OrderEntity.class);
    }
    public OrderDto toOrderDTO(OrderEntity orderEntity){
        return modelMapper.map(orderEntity, OrderDto.class);
    }

    public OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDto orderDetailsDto) {
            return modelMapper.map(orderDetailsDto, OrderDetailsEntity.class);
    }
}
