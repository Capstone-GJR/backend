package com.capstone.backend.services;


import com.capstone.backend.entity.Item;
import com.capstone.backend.exception.EntityNotFoundException;
import com.capstone.backend.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ItemServiceImp implements ItemService{

    ItemRepository itemRepository;
    ToteService toteService;


    @Override
    public Item getItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return unwrapItem(item, id);
    }

    @Override
    public Item saveItem(Item item, Long tote_id) {
        item.setTote(toteService.getTote(tote_id));
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItemsByUser(Long user_id) {
        return itemRepository.findAllByUserId(user_id);
    }

    @Override
    public List<Item> getAllItemsByTote(Long tote_id) {
        return itemRepository.findByToteId(tote_id);
    }

//    @Override
//    public List<Item> getAllItemsBySpace(Long space_id) {
//        return itemRepository.findBySpaceId(space_id);
//    }

    @Override
    public Item editItem(Long id, Long tote_id, Item item) {
        Item dbItem = getItem(id);
        dbItem.setName(item.getName());
        dbItem.setTags(item.getTags());
        dbItem.setColor(item.getColor());
        dbItem.setFileStackUrl(item.getFileStackUrl());
        dbItem.setValue(item.getValue());
        return saveItem(dbItem, tote_id);
    }


    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    static Item unwrapItem(Optional<Item> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Item.class);
    }
}
