package com.example.pos_backend.service;

import com.example.pos_backend.Dto.dto.ItemDto;

public interface ItemService {
    void saveItem(ItemDto itemDto);

    ItemDto getItemById(String code);

    boolean updateItem(String code, ItemDto itemDto);

    void deleteItem(String code);
}

