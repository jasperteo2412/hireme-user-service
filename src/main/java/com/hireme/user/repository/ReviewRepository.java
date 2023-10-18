package com.hireme.user.repository;

import com.hireme.user.entity.MessagesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends CrudRepository<MessagesEntity, Integer>  {
    @Query("SELECT r.review FROM ReviewEntity r WHERE r.name = :name")
    String getTutorReviewByName(@Param("name") String name);
}
