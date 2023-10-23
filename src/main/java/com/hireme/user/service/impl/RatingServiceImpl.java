package com.hireme.user.service.impl;

import com.hireme.user.entity.RatingEntity;
import com.hireme.user.entity.ReviewEntity;
import com.hireme.user.repository.RatingRepository;
import com.hireme.user.repository.ReviewRepository;
import com.hireme.user.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Float getTutorRatingByName(String name) {
        return ratingRepository.getTutorRatingByName(name);
    }


    public RatingEntity createRating(RatingEntity ratingEntity) {
        return ratingRepository.save(ratingEntity);
    }

    public void updateTutorRating(RatingEntity ratingEntity) {
        Float newRatingForTutor = ratingEntity.getRating();
        String tutorName = ratingEntity.getName();
        ratingRepository.updateTutorRating(newRatingForTutor, tutorName);
    }

    public void deleteTutorReviewByName(RatingEntity ratingEntity) {
        ratingRepository.delete(ratingEntity);
    }

    public RatingEntity getRatingEntityByName(String name) {
        return ratingRepository.findByName(name);
    }

    public List<RatingEntity> getAllRatings() {
        return ratingRepository.getAllRatings();
    }
}
