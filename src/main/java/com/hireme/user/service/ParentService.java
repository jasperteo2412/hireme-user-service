package com.hireme.user.service;

import com.hireme.user.entity.ParentEntity;
import com.hireme.user.entity.TutorEntity;
import com.hireme.user.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ParentService {
    private final ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<ParentEntity> findParentByName(String name) {
        ParentEntity parentEntity = new ParentEntity();
        return new ArrayList<>();
    }

//    public List<TutorEntity> findTutorByName(String name) {
//        return parentRepository.findTutorByName(name);
//    }

}
