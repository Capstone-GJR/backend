package com.capstone.backend.repository;

import com.capstone.backend.entity.Space;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SpaceRepository extends CrudRepository<Space, Long> {
    Optional<Space> findById(Long id);
}
