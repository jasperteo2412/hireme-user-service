package com.hireme.user.repository;

import com.hireme.user.entity.ParentEntity;
import com.hireme.user.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TutorRepository extends JpaRepository<TutorEntity, Integer> {
    @Query("SELECT u FROM TutorEntity u WHERE u.tutorName = ?1")
    List<TutorEntity> findTutorByName(String tutorName);
}
