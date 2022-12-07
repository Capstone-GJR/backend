package com.capstone.backend.web;

import com.capstone.backend.entity.Component;
import com.capstone.backend.services.ComponentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/{space_id}/component")
public class ComponentController {
    ComponentService componentService;

    @PostMapping("/add")
    public ResponseEntity<Component> createComponent(@Valid @RequestBody Component component, @PathVariable Long space_id) {
        return new ResponseEntity<>((componentService.saveComponent(component, space_id)), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Component> getById(@PathVariable Long id) {
        Component component = componentService.getComponent(id);
        return new ResponseEntity<>(component, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Component>> getAllBySpaceID (@PathVariable Long space_id) {
        List<Component> allComponents = componentService.getAllComponents(space_id);
        return new ResponseEntity<>(allComponents, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Component> deleteComponent (@PathVariable Long space_id, @PathVariable Long id) {
        componentService.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //TODO: Request body must include all fields except id and user? - Look into Dynamic Update for passing in only updated values.
    @PutMapping("/edit/{id}")
    public ResponseEntity<Component> editComponent (@PathVariable(name = "space_id") Long space_id, @PathVariable(name = "id") Long id, @RequestBody Component component) {
        Component editedComponent = componentService.editComponent(space_id, id, component);
        return new ResponseEntity<>(editedComponent, HttpStatus.OK);
    }
}
