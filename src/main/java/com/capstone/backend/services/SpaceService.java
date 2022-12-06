package com.capstone.backend.services;

import com.capstone.backend.entity.Space;

import java.util.List;

public interface SpaceService {
    Space getSpace(Long id);
    Space saveSpace(Space space, Long user_id);
    List<Space> getAllSpaces(Long user_id);
    Space editSpace(Long id, Space space, Long user_id);

    void deleteSpace(Long id);
}
