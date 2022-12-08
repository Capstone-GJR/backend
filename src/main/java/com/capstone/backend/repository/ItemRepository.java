package com.capstone.backend.repository;

import com.capstone.backend.entity.Item;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "SELECT DISTINCT items.* FROM items JOIN spaces on space_id JOIN users on users.id = spaces.user_id WHERE user_id = ?1", nativeQuery = true)
    List<Item> findAllByUserId (Long user_id);


}
//SELECT DISTINCT items.* FROM items
//            JOIN spaces on space_id
//            JOIN users u
//            on u.id = spaces.user_id
//            WHERE user_id = ?", nativeQuery = true)