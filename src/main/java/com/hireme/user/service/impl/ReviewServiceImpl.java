package com.hireme.user.service.impl;

import com.hireme.user.repository.RatingRepository;
import com.hireme.user.repository.ReviewRepository;
import com.hireme.user.service.RatingService;
import com.hireme.user.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public String getTutorReviewByName(String name) {
        return reviewRepository.getTutorReviewByName(name);
    }

}
