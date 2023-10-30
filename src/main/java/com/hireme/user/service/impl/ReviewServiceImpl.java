package com.hireme.user.service.impl;

import com.hireme.user.entity.ReviewEntity;
import com.hireme.user.repository.ReviewRepository;
import com.hireme.user.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public String getTutorReviewByName(String name) {
        return reviewRepository.getTutorReviewByName(name);
    }

    public ReviewEntity createReview(ReviewEntity reviewEntity) {
        return reviewRepository.save(reviewEntity);
    }

    public void updateTutorReview(ReviewEntity reviewRequest) {
        String newReviewForTutor = reviewRequest.getReview();
        String tutorName = reviewRequest.getName();
        reviewRepository.updateTutorReview(newReviewForTutor, tutorName);
    }

    public void deleteTutorReviewByName(ReviewEntity reviewEntity) {
        reviewRepository.delete(reviewEntity);
    }

    public ReviewEntity getReviewEntityByName(String name) {
        return reviewRepository.findByName(name);
    }

    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

}