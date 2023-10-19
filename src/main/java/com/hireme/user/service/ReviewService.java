package com.hireme.user.service;


import com.hireme.user.entity.ReviewEntity;

public interface ReviewService {
    public String getTutorReviewByName(String name);

    public ReviewEntity createReview(ReviewEntity reviewEntity);

    public void updateTutorReview(ReviewEntity reviewRequest);

    public void deleteTutorReviewByName(ReviewEntity reviewRequest);

    public ReviewEntity getReviewEntityByName(String name);
}
