package com.hireme.user.service.impl;

import com.hireme.user.entity.TutorEntity;
import com.hireme.user.exception.TutorServiceException;
import com.hireme.user.repository.TutorRepository;
import com.hireme.user.service.TutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {
    private static final Logger logger = LoggerFactory.getLogger(TutorServiceImpl.class);

    private final TutorRepository tutorRepository;

    @Autowired
    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }


    @Override
    public List<TutorEntity> findTutorByName(String tutorName) {
        logger.info("Finding tutors by name: {}", tutorName);

        if (tutorName == null || tutorName.isEmpty()) {
            throw new IllegalArgumentException("Name parameter is required.");
        }

        try {
            List<TutorEntity> tutors = tutorRepository.findTutorByName(tutorName);

            if (tutors.isEmpty()) {
                logger.info("No tutors found with name: {}", tutorName);
            } else {
                logger.info("Found {} tutors with name: {}", tutors.size(), tutorName);
            }

            return tutorRepository.findTutorByName(tutorName);
        } catch (Exception ex) {
            logger.error("Error finding tutors by name: {}", ex.getMessage(), ex);
            throw new TutorServiceException("Failed to find tutors by name: " + ex.getMessage(), ex);
        }
    }
}
