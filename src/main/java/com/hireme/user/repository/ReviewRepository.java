package com.hireme.user.repository;

import com.hireme.user.entity.MessagesEntity;
import com.hireme.user.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    @Query("SELECT r.review FROM ReviewEntity r WHERE r.name = :name")
    String getTutorReviewByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE ReviewEntity r SET r.review = :newReviewForTutor WHERE r.name = :tutorName")
    void updateTutorReview(String newReviewForTutor, String tutorName);

    @Query("SELECT r FROM ReviewEntity r WHERE r.name = :name")
    ReviewEntity findByName(String name);

    @Query("SELECT r FROM ReviewEntity r")
    List<ReviewEntity> getAllReviews();
}
