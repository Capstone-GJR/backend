package com.capstone.backend.services;

import com.capstone.backend.entity.Space;
import com.capstone.backend.exception.EntityNotFoundException;
import com.capstone.backend.repository.SpaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SpaceServiceImp implements SpaceService {

    private SpaceRepository spaceRepository;
    private UserService userService;


    @Override
    public Space getSpace(Long id) {
        Optional<Space> space = spaceRepository.findById(id);
        unwrapSpace(space, id);
        return unwrapSpace(space, id);
    }


    public Space editSpace(Long id, Space space, Long user_id) {
        Space dbSpace = getSpace(id);
        dbSpace.setName(space.getName());
        dbSpace.setKeywords(space.getKeywords());
        dbSpace.setColor(space.getColor());
        dbSpace.setFileStackURL(space.getFileStackURL());
        saveSpace(dbSpace, user_id);
        return dbSpace;
    }

    @Override
    public List<Space> getAllSpaces(Long user_id) {
        return spaceRepository.findByUserId(user_id);
    }

    @Override
    public Space saveSpace(Space space, Long user_id) {
        space.setUser(userService.getUser(user_id));
        return spaceRepository.save(space);
    }

    @Override
    public void deleteSpace(Long id) {
        spaceRepository.deleteById(id);
    }

    static Space unwrapSpace(Optional<Space> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Space.class);
    }

} // SpaceServiceImp
