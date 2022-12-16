package com.capstone.backend.services;

import com.capstone.backend.entity.Tote;

import java.util.List;

public interface ToteService {

    Tote saveTote(Tote tote, Long space_id);
    Tote getTote(Long id);
    List<Tote> getAllTotes(Long space_id);
    void deleteTote(Long id);
    Tote editTote(Long space_id, Long id, Tote tote);
}
