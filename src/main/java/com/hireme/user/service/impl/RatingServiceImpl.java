package com.hireme.user.service.impl;

import com.hireme.user.repository.RatingRepository;
import com.hireme.user.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Float getTutorRatingByName(String name) {
        return ratingRepository.getTutorRatingByName(name);
    }
}
