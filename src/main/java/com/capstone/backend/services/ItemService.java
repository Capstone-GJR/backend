package com.capstone.backend.services;

import com.capstone.backend.entity.Item;

import java.util.List;

public interface ItemService {
    Item getItem(Long id);
    Item saveItem(Item item);
    List<Item> getAllItemsByComponent(Long component_id);
    List<Item> getAllItemsBySpace(Long space_id);
    Item editItem(Long id, Item item);
    void deleteItem(Long id);

}
