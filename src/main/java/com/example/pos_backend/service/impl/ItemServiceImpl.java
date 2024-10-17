package com.example.pos_backend.service.impl;

import com.example.pos_backend.Dao.CustomerDao;
import com.example.pos_backend.Dao.ItemDao;
import com.example.pos_backend.Dto.dto.ItemDto;
import com.example.pos_backend.Entity.ItemEntity;
import com.example.pos_backend.exceotion.DataPersistException;
import com.example.pos_backend.exceotion.UserNotFoundException;
import com.example.pos_backend.service.ItemService;
import com.example.pos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping itemMapping;

    @Override
    public void saveItem(ItemDto itemDto) {
        ItemEntity saveItem = itemDao.save(itemMapping.toItemEntity(itemDto));
        if(saveItem==null){
            throw new DataPersistException("Item not Saved !!!");
        }
    }

    @Override
    public ItemDto getItemById(String code) {
        ItemEntity select_item = itemDao.getReferenceById(code);
        return itemMapping.toItemDto(select_item);
    }

    @Override
    public boolean updateItem(String code, ItemDto itemDto) {
        Optional<ItemEntity> tmpItem = itemDao.findById(code);
        if(tmpItem.isPresent()){
            tmpItem.get().setName(itemDto.getName());
            tmpItem.get().setDescription(itemDto.getDescription());
            tmpItem.get().setQty(Integer.parseInt(itemDto.getQty()));
            tmpItem.get().setUnitPrice(Integer.parseInt(itemDto.getUnitPrice()));
        }
        return false;
    }

    @Override
    public void deleteItem(String code) {
        Optional<ItemEntity> selectItem = itemDao.findById(code);
        if(!selectItem.isPresent()){
            throw new UserNotFoundException("Item with id " + code + " not found");
        }else {
            itemDao.deleteById(code);
        }
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemEntity> all = itemDao.findAll();
        return itemMapping.asItemDtoList(all);
    }
}
