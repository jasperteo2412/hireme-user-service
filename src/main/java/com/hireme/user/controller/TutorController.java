package com.hireme.user.controller;

import com.hireme.user.entity.TutorEntity;
import com.hireme.user.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    private final TutorService tutorService;

    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("/findByName/{name}")
    public List<TutorEntity> findTutorByName(@PathVariable String name) {
        name = name.replace("+", " ");
        return tutorService.findTutorByName(name);

    }
}