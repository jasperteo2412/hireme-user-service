package com.hireme.user.repository;

import com.hireme.user.entity.MessagesEntity;
import com.hireme.user.entity.RatingEntity;
import com.hireme.user.entity.ReviewEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RatingRepository extends CrudRepository<RatingEntity, Integer>  {
    @Query("SELECT r.rating FROM RatingEntity r WHERE r.name = :name")
    Float getTutorRatingByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE RatingEntity r SET r.rating = :newRatingForTutor WHERE r.name = :tutorName")
    void updateTutorRating(Float newRatingForTutor, String tutorName);

    @Query("SELECT r FROM RatingEntity r WHERE r.name = :name")
    RatingEntity findByName(String name);

    @Query("SELECT r FROM RatingEntity r")
    List<RatingEntity> getAllRatings();
}