package com.hireme.user.service;

import com.hireme.user.entity.TutorEntity;
import com.hireme.user.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;

    @Autowired
    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<TutorEntity> findTutorByName(String name) {
        return tutorRepository.findTutorByName(name);
    }

}
