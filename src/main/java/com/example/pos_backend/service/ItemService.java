package com.example.pos_backend.service;

import com.example.pos_backend.Dto.dto.ItemDto;
import com.example.pos_backend.Dto.status.ItemStatus;

public interface ItemService {
    void saveItem(ItemDto itemDto);

    ItemDto getItemById(String code);

    boolean updateItem(String code, ItemDto itemDto);

    void deleteItem(String code);
}

