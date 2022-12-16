package com.capstone.backend.web;

import com.capstone.backend.entity.Tote;
import com.capstone.backend.services.ToteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tote")
public class ToteController {
    ToteService toteService;

    @PostMapping("/add/{space_id}")
    public ResponseEntity<Tote> createTote(@RequestBody Tote tote, @PathVariable Long space_id) {
        return new ResponseEntity<>((toteService.saveTote(tote, space_id)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tote> getById(@PathVariable Long id) {
        Tote tote = toteService.getTote(id);
        return new ResponseEntity<>(tote, HttpStatus.OK);
    }

    @GetMapping("/all/{space_id}")
    public ResponseEntity<List<Tote>> getAllBySpaceID (@PathVariable Long space_id) {
        List<Tote> allTotes = toteService.getAllTotes(space_id);
        return new ResponseEntity<>(allTotes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tote> deleteTote (@PathVariable Long id) {
        toteService.deleteTote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//TODO: Request body must include all fields except id and user? - Look into Dynamic Update for passing in only updated values.
    @PutMapping("/edit/{id}/{space_id}")
    public ResponseEntity<Tote> editTote (@PathVariable Long space_id, @PathVariable(name = "id") Long id, @RequestBody Tote tote) {;
        Tote editedTote = toteService.editTote(space_id, id, tote);
        return new ResponseEntity<>(editedTote, HttpStatus.OK);
    }
}
