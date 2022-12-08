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
    SpaceService spaceService;

    @Override
    public Item getItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return unwrapItem(item, id);
    }

    @Override
    public Item saveItem(Item item, Long space_id) {
        item.setSpace(spaceService.getSpace(space_id));
        return itemRepository.save(item);
    }

//    @Override
//    public List<Item> getAllItemsByUser(Long user_id) {
//        return itemRepository.findBySpaceIdWhereUserId(user_id);
//    }

    @Override
    public List<Item> getAllItemsByTote(Long tote_id) {
        return itemRepository.findByToteId(tote_id);
    }

    @Override
    public List<Item> getAllItemsBySpace(Long space_id) {
        return itemRepository.findBySpaceId(space_id);
    }

    @Override
    public Item editItem(Long id, Item item) {
        Item dbItem = getItem(id);
        dbItem.setName(item.getName());
        dbItem.setKeywords(item.getKeywords());
        dbItem.setColor(item.getColor());
        dbItem.setFileStackUrl(item.getFileStackUrl());
        dbItem.setCheckedOut(item.isCheckedOut());
        dbItem.setTote(item.getTote());
        dbItem.setValue(item.getValue());
        return saveItem(dbItem, dbItem.getSpace().getId());
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
