package com.example.pos_backend.controller;

import com.example.pos_backend.Dto.dto.ItemDto;
import com.example.pos_backend.service.ItemService;
import com.example.pos_backend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(
            @RequestPart()String  name,
            @RequestPart()String description,
            @RequestPart()String qty,
            @RequestPart()String unitPrice
    )
    {
        String item_code = AppUtil.generateItemId();
        ItemDto itemDto = new ItemDto();
        itemDto.setCode(item_code);
        itemDto.setName(name);
        itemDto.setDescription(description);
        itemDto.setQty(qty);
        itemDto.setUnitPrice(unitPrice);

        itemService.saveItem(itemDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
