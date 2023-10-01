package com.hireme.user.repository;

import com.hireme.user.entity.AdminEntity;
import com.hireme.user.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<ParentEntity, Integer> {
}
