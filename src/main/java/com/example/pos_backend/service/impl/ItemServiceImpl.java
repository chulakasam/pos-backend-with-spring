package com.example.pos_backend.service.impl;

import com.example.pos_backend.Dao.CustomerDao;
import com.example.pos_backend.Dao.ItemDao;
import com.example.pos_backend.Dto.dto.ItemDto;
import com.example.pos_backend.Entity.ItemEntity;
import com.example.pos_backend.exceotion.DataPersistException;
import com.example.pos_backend.service.ItemService;
import com.example.pos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
