package com.capstone.backend.services;

import com.capstone.backend.entity.Tote;
import com.capstone.backend.exception.EntityNotFoundException;
import com.capstone.backend.repository.ToteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ToteServiceImp implements ToteService {
    SpaceService spaceService;
    ToteRepository toteRepository;
    //    public Tote saveTote(Tote tote, Long space_id) {
    //        tote.setSpace(spaceService.getSpace(space_id));
    //        return toteRepository.save(tote);
    //    }

    @Override
    public Tote saveTote(Tote tote, Long space_id) {
        tote.setSpace(spaceService.getSpace(space_id));
        return toteRepository.save(tote);
    }

    @Override
    public Tote getTote(Long id) {
        Optional<Tote> tote = toteRepository.findById(id);
        return unwrapTote(tote, id);
    }

    @Override
    public List<Tote> getAllTotes(Long space_id) {
        return toteRepository.findBySpaceId(space_id);
    }

    @Override
    public void deleteTote(Long id) {
        toteRepository.deleteById(id);
    }
//Double check this for accuracy after adjustments to the save tote method
    @Override
    public Tote editTote(Long space_id, Long id, Tote tote) {
        Tote dbTote = getTote(id);
        dbTote.setSpace(tote.getSpace()); // move to new space
        dbTote.setName(tote.getName());
        dbTote.setKeywords(tote.getKeywords());
        dbTote.setColor(tote.getColor());
        dbTote.setFileStackUrl(tote.getFileStackUrl());
//        dbTote.setParent_id(tote.getParent_id());
        dbTote.setCheckedOut(tote.isCheckedOut());
        dbTote.setSpace(spaceService.getSpace(space_id));
        return saveTote(dbTote, space_id);
    }

    static Tote unwrapTote(Optional<Tote> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Tote.class);
    }
}
