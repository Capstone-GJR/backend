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
    ComponentService componentService;
    SpaceService spaceService;

    @Override
    public Item getItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return unwrapItem(item, id);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItemsByComponent(Long component_id) {
        return itemRepository.findByComponentId(component_id);
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
        dbItem.setSpace(item.getSpace());
        dbItem.setComponent(item.getComponent());
        return null;
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
