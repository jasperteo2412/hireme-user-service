package com.hireme.user.service.impl;

import com.hireme.user.dto.UserDTO;
import com.hireme.user.entity.UserEntity;
import com.hireme.user.mapper.EntityToDtoMapper;
import com.hireme.user.repository.CommunicationRepository;
import com.hireme.user.repository.UserRepository;
import com.hireme.user.repository.UserSearchRepository;
import com.hireme.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EntityToDtoMapper entityToDtoMapper;
    @Autowired
    private UserSearchRepository userRepository;

    public List<UserDTO> searchUsername(String searchUser) {
        String search = "%"+searchUser+"%";

        List<UserEntity> userList = userRepository.findByUserNameLike(search);
        List<UserDTO> results = entityToDtoMapper.convertUserEntityToDto(userList);

        return results;
    }
}
