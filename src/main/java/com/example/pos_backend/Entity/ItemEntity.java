package com.example.pos_backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity implements SuperEntity{
    @Id
   private String itemCode;
    private String name;
    private String description;
    private String qty;
    private String unitPrice;
//    @OneToMany(mappedBy = "item")
//    private List<OrderDetailsEntity> orderDetailsEntityList;
}
