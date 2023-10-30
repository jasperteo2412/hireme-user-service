package com.hireme.user.repository;

import com.hireme.user.entity.MessagesEntity;
import com.hireme.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserSearchRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByUserNameLike(String userSearch);
}
