package com.hireme.user.service;

import com.hireme.user.entity.TutorEntity;
import com.hireme.user.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

//    public List<TutorEntity> findTutorByName(String name) {
//        return tutorRepository.findTutorByName(name);
//    }

}
