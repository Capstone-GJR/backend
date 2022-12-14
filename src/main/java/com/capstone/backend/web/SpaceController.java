package com.capstone.backend.web;

import com.capstone.backend.entity.Space;
import com.capstone.backend.services.SpaceService;
import com.capstone.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000, https://traqura.xyz")
@RequestMapping("/space")
public class SpaceController {
    //TODO: Find by keyword/search

    SpaceService spaceService;
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Space> createSpace(@Valid @RequestBody Space space, Principal user) {
        Long user_id = userService.getUser(user.getName()).getId();
        return new ResponseEntity<>((spaceService.saveSpace(space, user_id)), HttpStatus.CREATED);
    }

    //TODO: How to handle exception if no user with that id exists. ?? Check if user exists before checking if space exists?
    @GetMapping("/{id}")
    public ResponseEntity<Space> getById(@PathVariable Long id) {
        Space space = spaceService.getSpace(id);
        return new ResponseEntity<>(space, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Space>> getAllByUserID(Principal user) {
        Long user_id = userService.getUser(user.getName()).getId();
        List<Space> allSpaces = spaceService.getAllSpaces(user_id);
        return new ResponseEntity<>(allSpaces, HttpStatus.OK);
    }

    //TODO: Request body must include all fields except id and user? - Look into Dynamic Update for passing in only updated values.
    @PutMapping("/edit/{id}")
    public ResponseEntity<Space> editSpace(Principal user ,@PathVariable(name = "id") Long id, @RequestBody Space space) {
        Long user_id = userService.getUser(user.getName()).getId();
        Space editedSpace = spaceService.editSpace(id, space, user_id);
        return new ResponseEntity<>(editedSpace, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Space> deleteSpace(@PathVariable Long id) {
        spaceService.deleteSpace(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
