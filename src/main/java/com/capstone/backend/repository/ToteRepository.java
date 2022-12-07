package com.capstone.backend.repository;

import com.capstone.backend.entity.Tote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToteRepository extends CrudRepository<Tote, Long> {
    Optional<Tote> findById(Long id);
    List<Tote> findBySpaceId(Long space_id);
    void deleteById(Long id);
}
