package com.capstone.backend.repository;

import com.capstone.backend.entity.Component;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepository extends CrudRepository<Component, Long> {
}
