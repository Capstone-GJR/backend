package com.capstone.backend.services;

import com.capstone.backend.entity.Component;
import com.capstone.backend.exception.EntityNotFoundException;
import com.capstone.backend.repository.ComponentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComponentServiceImp implements ComponentService {
    SpaceService spaceService;
    ComponentRepository componentRepository;
    @Override
    public Component saveComponent(Component component, Long space_id) {
        component.setSpace(spaceService.getSpace(space_id));
        return componentRepository.save(component);
    }

    @Override
    public Component getComponent(Long id) {
        Optional<Component> component = componentRepository.findById(id);
        return unwrapComponent(component, id);
    }

    @Override
    public List<Component> getAllComponents(Long space_id) {
        return componentRepository.findBySpaceId(space_id);
    }

    @Override
    public void deleteComponent(Long id) {
        componentRepository.deleteById(id);
    }

    @Override
    public Component editComponent(Long space_id, Long id, Component component){
        Component dbComponent = getComponent(id);
        dbComponent.setSpace(component.getSpace()); // move to new space
        dbComponent.setName(component.getName());
        dbComponent.setKeywords(component.getKeywords());
        dbComponent.setColor(component.getColor());
        dbComponent.setFileStackUrl(component.getFileStackUrl());
        dbComponent.setParent_id(component.getParent_id());
        dbComponent.setCheckedOut(component.isCheckedOut());
        dbComponent.setSpace(spaceService.getSpace(space_id));
       return saveComponent(dbComponent, space_id);
    }

    static Component unwrapComponent(Optional<Component> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Component.class);
    }
}
