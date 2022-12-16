package com.capstone.backend.services;

import com.capstone.backend.entity.Item;

import java.util.List;

public interface ItemService {
    Item getItem(Long id);

    Item saveItem(Item item, Long tote_id);

    List<Item> getAllItemsByTote(Long tote_id);

//    List<Item> getAllItemsBySpace(Long space_id);

    List<Item> getAllItemsByUser(Long user_id);

    Item editItem(Long id, Long tote_id, Item item);

    void deleteItem(Long id);

}
