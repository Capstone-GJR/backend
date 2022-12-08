package com.capstone.backend.repository;

import com.capstone.backend.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<Item> findById(Long id);
    List<Item> findBySpaceId(Long space_id);
    List<Item> findByToteId(Long tote_id);
    void deleteById(Long id);
//    List<Item> findAllBySpaceIdJoin(Long user_id);

}
