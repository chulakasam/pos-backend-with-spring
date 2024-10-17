package com.example.pos_backend.Dto.dto;

import com.example.pos_backend.Dto.status.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto implements ItemStatus {
    private String code;
    private String name;
    private String description;
    private String qty;
    private String unitPrice;
}
