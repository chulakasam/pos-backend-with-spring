package com.example.pos_backend.Dto.dto;

import com.example.pos_backend.Dto.status.ReqOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqOrderDto implements ReqOrderStatus {
    private OrderDto orderDto;
    private List<OrderDetailsDto> orderDetails;
}
