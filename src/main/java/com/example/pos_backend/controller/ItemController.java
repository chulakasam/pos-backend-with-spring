package com.example.pos_backend.controller;

import com.example.pos_backend.Dto.dto.ItemDto;
import com.example.pos_backend.Dto.status.ItemStatus;
import com.example.pos_backend.customStatusCodes.SelectedUserErrorStatus;
import com.example.pos_backend.exceotion.DataPersistException;
import com.example.pos_backend.exceotion.UserNotFoundException;
import com.example.pos_backend.service.ItemService;
import com.example.pos_backend.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger= LoggerFactory.getLogger(ItemController.class);

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(
            @RequestPart("name")String  name,
            @RequestPart("description")String description,
            @RequestPart("qty")String qty,
            @RequestPart("unitPrice")String unitPrice
    )
    {
        try{
            String item_code = AppUtil.generateItemId();
            ItemDto itemDto = new ItemDto();
            itemDto.setCode(item_code);
            itemDto.setName(name);
            itemDto.setDescription(description);
            itemDto.setQty(qty);
            itemDto.setUnitPrice(unitPrice);

            itemService.saveItem(itemDto);
            logger.info("item saved successfully !!!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{itemCode}",produces= MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getSelectedItem(@PathVariable("itemCode") String itemCode){
        String regexForItemCode = "^ITEM-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForItemCode);
        var regexMatcher = regexPattern.matcher(itemCode);

        if (!regexMatcher.matches()) {
            return new SelectedUserErrorStatus(1,"Item Code is not valid");
        }
        return itemService.getItemById(itemCode);
    }

    @PutMapping(value = "/{itemCode}",consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateItem(
            @RequestPart("name")String  name,
            @RequestPart("description")String description,
            @RequestPart("qty")String qty,
            @RequestPart("unitPrice")String unitPrice,
            @PathVariable("itemCode") String itemCode
    ){
        ItemDto itemDto = new ItemDto();
        itemDto.setCode(itemCode);
        itemDto.setName(name);
        itemDto.setDescription(description);
        itemDto.setQty(qty);
        itemDto.setUnitPrice(unitPrice);

        itemService.updateItem(itemCode,itemDto);

    }

    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<Void> deleteItem(@PathVariable("itemCode") String itemCode){
        String regexForItemCode = "^ITEM-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForItemCode);
        var regexMatcher = regexPattern.matcher(itemCode);

        try {
            if (!regexMatcher.matches()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.deleteItem(itemCode);
            logger.info("Item deleted successfully !!!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
