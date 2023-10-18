package com.hireme.user.controller;


import com.hireme.user.service.RatingService;
import com.hireme.user.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class ReviewController {

    static final Logger logger = Logger.getLogger(CommunicationController.class.getName());

    @Autowired
    private ReviewService reviewService;

    @GetMapping(value = "/review/getTutorReviewByName/{tutorName}")
    @Operation(summary = "Get review by tutor name")
    @ApiResponse(responseCode = "200", description = "Get tutor review successfully")
    private String getTutorReviewByName(@PathVariable String tutorName) {
        return reviewService.getTutorReviewByName(tutorName);
    }


}
