package com.hireme.user.controller;


import com.hireme.user.entity.RatingEntity;
import com.hireme.user.entity.ReviewEntity;
import com.hireme.user.service.RatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class RatingController {

    static final Logger logger = Logger.getLogger(CommunicationController.class.getName());

    @Autowired
    private RatingService ratingService;


    @PostMapping(value = "/rating/createTutorRating")
    @Operation(summary = "create new rating for tutor")
    @ApiResponse(responseCode = "200", description = "Create tutor rating successfully")
    public String createTutorRating(@RequestBody RatingEntity ratingRequest) {
        String tutorName = ratingRequest.getName();
        if (ratingService.getTutorRatingByName(tutorName) != null) {
            return "Tutor rating already exist. Please update instead";
        }
        RatingEntity ratingEntity = new RatingEntity();
        ratingEntity.setName(ratingRequest.getName());
        ratingEntity.setRating(ratingRequest.getRating());
        ratingService.createRating(ratingEntity);

        return "Create tutor rating successfully";
    }


    @GetMapping(value = "/rating/getTutorRatingByName/{tutorName}")
    @Operation(summary = "Get rating by tutor name")
    @ApiResponse(responseCode = "200", description = "Get tutor rating successfully")
    private float getTutorRatingByName(@PathVariable String tutorName) {
        return ratingService.getTutorRatingByName(tutorName);
    }


    @PostMapping(value="/rating/updateTutorRatingByName")
    @Operation(summary="Update rating by tutor name")
    @ApiResponse(responseCode="200", description="Update tutor rating successfully")
    public String updateTutorRatingByName(@RequestBody RatingEntity ratingRequest) {
        String tutorName = ratingRequest.getName();
        if (ratingService.getRatingEntityByName(tutorName) == null) {
            return "No such tutor exist";
        }
        if (ratingService.getTutorRatingByName(tutorName) == null) {
            return "Tutor currently does not have rating. Please create one first";
        }
        ratingService.updateTutorRating(ratingRequest);
        return "Update tutor rating successfully";
    }

    @DeleteMapping(value="/rating/deleteTutorReviewByName/{tutorName}")
    @Operation(summary = "Delete rating by tutor name")
    @ApiResponse(responseCode = "200", description = "Delete tutor rating successfully")
    public String deleteTutorRatingByName(@PathVariable String tutorName) {
        RatingEntity ratingRequest = ratingService.getRatingEntityByName(tutorName);
        ratingService.deleteTutorReviewByName(ratingRequest);
        return "Successfully delete tutor rating";
    }


}
