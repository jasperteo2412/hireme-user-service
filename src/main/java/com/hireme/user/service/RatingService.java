package com.hireme.user.service;



import com.hireme.user.dto.RatingDTO;
import com.hireme.user.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface RatingService {
    public Float getTutorRatingByName(String name);

}
