package com.example.pos_backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity {
 @Id
 private String orderId;
 private String customerId;
 private LocalDate orderDate;
 @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
 private List<OrderDetailsEntity> orderDetailsEntityList;
}
