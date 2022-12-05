package com.capstone.backend.services;

import com.capstone.backend.entity.Space;
import com.capstone.backend.exception.EntityNotFoundException;
import com.capstone.backend.repository.SpaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class SpaceServiceImp implements SpaceService {

    private SpaceRepository spaceRepository;
    private UserService userService;


    @Override
    public Space getSpace(Long id) {
        Optional<Space> space = spaceRepository.findById(id);
        return unwrapSpace(space, id);
    }

    @Override
    public Space saveSpace(Space space) {
        return spaceRepository.save(space);
    }

    static Space unwrapSpace(Optional<Space> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Space.class);
    }

} // SpaceServiceImp
