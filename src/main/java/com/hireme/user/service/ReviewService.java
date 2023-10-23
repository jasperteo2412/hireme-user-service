package com.hireme.user.service;


import com.hireme.user.entity.RatingEntity;
import com.hireme.user.entity.ReviewEntity;

import java.util.List;

public interface ReviewService {
    public String getTutorReviewByName(String name);

    public ReviewEntity createReview(ReviewEntity reviewEntity);

    public void updateTutorReview(ReviewEntity reviewRequest);

    public void deleteTutorReviewByName(ReviewEntity reviewRequest);

    public ReviewEntity getReviewEntityByName(String name);

    List<ReviewEntity> getAllReviews();
}
