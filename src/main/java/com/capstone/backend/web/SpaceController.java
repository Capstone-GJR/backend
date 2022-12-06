package com.capstone.backend.web;

import com.capstone.backend.entity.Space;
import com.capstone.backend.services.SpaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/{user_id}/space")
public class SpaceController {

    SpaceService spaceService;

    @PostMapping("/add")
    public ResponseEntity<Space> createSpace(@Valid@RequestBody Space space, @PathVariable Long user_id) {
        return new ResponseEntity<>((spaceService.saveSpace(space, user_id)), HttpStatus.CREATED);
    }
//TODO: How to handle exception if no user with that id exists. ?? Check if user exists before checking if space exists?
    @GetMapping("/{id}")
    public ResponseEntity<Space> getById(@PathVariable Long id, @PathVariable Long user_id) {
        Space space = spaceService.getSpace(id);
        return new ResponseEntity<>(space, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Space>> getAllByUserID (@PathVariable Long user_id) {
        List<Space> allSpaces = spaceService.getAllSpaces(user_id);
        return new ResponseEntity<>(allSpaces, HttpStatus.OK);
    }
}
