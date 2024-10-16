package com.example.pos_backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntity implements SuperEntity{
    @Id
    private String detailsId;
    @ManyToOne
    @JoinColumn(name = "orderId",referencedColumnName = "orderId")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "itemCode")
    private ItemEntity item;
    private int orderQty;

    private double unitPrice;

}
