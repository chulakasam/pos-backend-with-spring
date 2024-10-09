package com.example.pos_backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity {
   @Id
    private String orderID;
    private String date;
    private String cusID;
    private double discount_value;
    private double sub_total;
    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private CustomerEntity customer;
    @OneToMany(mappedBy = "order")
    private List<OrderDetailsEntity> orderDetailsList;
}
