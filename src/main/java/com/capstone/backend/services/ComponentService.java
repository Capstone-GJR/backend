package com.capstone.backend.services;

import com.capstone.backend.entity.Component;

import java.util.List;

public interface ComponentService {

    Component saveComponent(Component component, Long space_id);
    Component getComponent(Long id);
    List<Component> getAllComponents(Long space_id);
    void deleteComponent(Long id);
    Component editComponent(Long space_id, Long id, Component component);
}
