package com.hireme.user.repository;

import com.hireme.user.entity.MessagesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends CrudRepository<MessagesEntity, Integer>  {
    @Query("SELECT r.rating FROM RatingEntity r WHERE r.name = :name")
    Float getTutorRatingByName(@Param("name") String name);
}
