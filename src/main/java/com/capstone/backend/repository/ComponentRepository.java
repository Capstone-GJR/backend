package com.capstone.backend.repository;

import com.capstone.backend.entity.Component;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComponentRepository extends CrudRepository<Component, Long> {
    Optional<Component> findById(Long id);
    List<Component> findBySpaceId(Long space_id);
    void deleteById(Long id);
}
