package com.hireme.user.service;

import com.hireme.user.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    private final ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

//    public List<TutorEntity> findTutorByName(String name) {
//        return parentRepository.findTutorByName(name);
//    }

}
