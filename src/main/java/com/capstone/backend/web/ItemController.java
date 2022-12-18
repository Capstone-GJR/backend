package com.capstone.backend.web;

import com.capstone.backend.entity.Item;
import com.capstone.backend.services.ItemService;
import com.capstone.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "/**")
@RequestMapping("/item")
public class ItemController {

    ItemService itemService;
    UserService userService;

//Cannot read values of spaceID and toteID when passed in Request body
    @PostMapping("/add/{tote_id}")
    public ResponseEntity<Item> createItem(@RequestBody Item item, @PathVariable Long tote_id) {
        return new ResponseEntity<>((itemService.saveItem(item, tote_id)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable Long id) {
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllByUserId (Principal user) {
        Long user_id = userService.getUser(user.getName()).getId();
        return new ResponseEntity<>(itemService.getAllItemsByUser(user_id), HttpStatus.OK);
    }

    @GetMapping("/all/tote/{tote_id}")
    public ResponseEntity<List<Item>> getAllByToteId (@PathVariable Long tote_id) {
        List<Item> allItemsInTote = itemService.getAllItemsByTote(tote_id);
        return new ResponseEntity<>(allItemsInTote, HttpStatus.OK);
    }

//    Removed Tote field so do not currently need this method
//    @GetMapping("/all/space/{space_id}")
//    public ResponseEntity<List<Item>> getAllBySpaceId (@PathVariable Long space_id) {
//        List<Item> allItemsInSpace = itemService.getAllItemsBySpace(space_id);
//        return new ResponseEntity<>(allItemsInSpace, HttpStatus.OK);
//    }

    @PutMapping("/edit/{id}/{tote_id}")
    public ResponseEntity<Item> editItem (@PathVariable Long tote_id, @PathVariable(name = "id") Long id, @RequestBody Item item) {
        Item editedItem = itemService.editItem(id, tote_id, item);
        return new ResponseEntity<>(editedItem, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Item> deleteItem (@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
