package com.capstone.backend.services;

import com.capstone.backend.entity.Space;

public interface SpaceService {
    Space getSpace(Long id);
    Space saveSpace(Space space, Long user_id);
}
