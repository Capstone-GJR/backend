package com.capstone.backend.web;

import com.capstone.backend.entity.Item;
import com.capstone.backend.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/item")
public class ItemController {

    ItemService itemService;

//Cannot read values of spaceID and componentID when passed in Request body
    @PostMapping("/add/space{space_id}")
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item, @PathVariable Long space_id) {
        return new ResponseEntity<>((itemService.saveItem(item, space_id)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable Long id) {
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/all/component/{component_id}")
    public ResponseEntity<List<Item>> getAllByComponentId (@PathVariable Long component_id) {
        List<Item> allItemsInComponent = itemService.getAllItemsByComponent(component_id);
        return new ResponseEntity<>(allItemsInComponent, HttpStatus.OK);
    }

// FIXME : returning an empty array
    @GetMapping("/all/space/{space_id}")
    public ResponseEntity<List<Item>> getAllBySpaceId (@PathVariable Long space_id) {
        List<Item> allItemsInSpace = itemService.getAllItemsByComponent(space_id);
        return new ResponseEntity<>(allItemsInSpace, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Item> editItem (@PathVariable(name = "id") Long id, @RequestBody Item item) {
        Item editedItem = itemService.editItem(id, item);
        return new ResponseEntity<>(editedItem, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Item> deleteItem (@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}