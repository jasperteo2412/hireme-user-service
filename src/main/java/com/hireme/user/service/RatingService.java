package com.hireme.user.service;



import com.hireme.user.dto.RatingDTO;
import com.hireme.user.entity.RatingEntity;
import com.hireme.user.entity.ReviewEntity;
import com.hireme.user.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface RatingService {
    public Float getTutorRatingByName(String name);

    public RatingEntity createRating(RatingEntity ratingEntity);

    public void updateTutorRating(RatingEntity ratingEntity);

    public void deleteTutorReviewByName(RatingEntity ratingEntity);

    public RatingEntity getRatingEntityByName(String name);
}
