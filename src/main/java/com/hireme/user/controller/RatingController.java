package com.hireme.user.controller;


import com.hireme.user.service.RatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class RatingController {

    static final Logger logger = Logger.getLogger(CommunicationController.class.getName());

    @Autowired
    private RatingService ratingService;

    @GetMapping(value = "/rating/getTutorRatingByName/{tutorName}")
    @Operation(summary = "Get rating by tutor name")
    @ApiResponse(responseCode = "200", description = "Get tutor rating successfully")
    private float getTutorRatingByName(@PathVariable String tutorName) {
        return ratingService.getTutorRatingByName(tutorName);
    }


}
