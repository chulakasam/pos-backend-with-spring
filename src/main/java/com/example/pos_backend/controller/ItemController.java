package com.example.pos_backend.controller;

import com.example.pos_backend.Dto.dto.ItemDto;
import com.example.pos_backend.service.ItemService;
import com.example.pos_backend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(
            @RequestPart("name")String  name,
            @RequestPart("description")String description,
            @RequestPart("qty")String qty,
            @RequestPart("unitPrice")String unitPrice
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
    @GetMapping(value = "/{itemCode}",produces= MediaType.APPLICATION_JSON_VALUE)
    public ItemDto getSelectedUser(@PathVariable("itemCode") String itemCode){
        return itemService.getItemById(itemCode);
    }




}
