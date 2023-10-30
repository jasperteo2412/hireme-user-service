package com.hireme.user.controller;


import com.hireme.user.entity.RatingEntity;
import com.hireme.user.entity.ReviewEntity;
import com.hireme.user.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ReviewController {
    static final Logger logger = Logger.getLogger(CommunicationController.class.getName());

    @Autowired
    private ReviewService reviewService;


    @PostMapping(value = "/review/createTutorReview")
    @Operation(summary = "create new review for tutor")
    @ApiResponse(responseCode = "200", description = "Create tutor review successfully")
    public String createTutorReview(@RequestBody ReviewEntity reviewRequest) {
        String tutorName = reviewRequest.getName();
        if (reviewService.getTutorReviewByName(tutorName) != null) {
            return "Tutor review already exist. Please update instead";
        }
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setName(reviewRequest.getName());
        reviewEntity.setReview(reviewRequest.getReview());
        reviewService.createReview(reviewEntity);

        return "Create tutor review successfully";
    }

    @GetMapping(value = "/review/getTutorReviewByName/{tutorName}")
    @Operation(summary = "Get review by tutor name")
    @ApiResponse(responseCode = "200", description = "Get tutor review successfully")
    public String getTutorReviewByName(@PathVariable String tutorName) {
        return reviewService.getTutorReviewByName(tutorName);
    }

    @PostMapping(value="/review/updateTutorReviewByName")
    @Operation(summary="Update review by tutor name")
    @ApiResponse(responseCode="200", description="Update tutor review successfully")
    public String updateTutorReviewByName(@RequestBody ReviewEntity reviewRequest) {
        String tutorName = reviewRequest.getName();
        if (reviewService.getReviewEntityByName(tutorName   ) == null) {
            return "No such tutor exist";
        }
        if (reviewService.getTutorReviewByName(tutorName) == null) {
            return "Tutor currently does not have review. Please create one first";
        }
        reviewService.updateTutorReview(reviewRequest);
        return "Update tutor review successfully";
    }

    @DeleteMapping(value="/review/deleteTutorReviewByName/{tutorName}")
    @Operation(summary = "Delete review by tutor name")
    @ApiResponse(responseCode = "200", description = "Delete tutor review successfully")
    public String deleteTutorReviewByName(@PathVariable String tutorName) {
        ReviewEntity reviewRequest = reviewService.getReviewEntityByName(tutorName);
        reviewService.deleteTutorReviewByName(reviewRequest);
        return "Successfully delete tutor review";
    }

    @GetMapping(value="/review/getAllReviews")
    @Operation(summary="Get all reviews")
    @ApiResponse(responseCode = "200", description = "Get all reviews successfully")
    public List<ReviewEntity> getAllReviews() {
        return reviewService.getAllReviews();
    }

}