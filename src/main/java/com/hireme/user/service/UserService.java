package com.hireme.user.service;

import com.hireme.user.dto.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> searchUsername(String searchUser);
}
