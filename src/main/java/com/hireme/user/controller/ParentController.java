package com.hireme.user.controller;

import com.hireme.user.entity.ParentEntity;
import com.hireme.user.entity.TutorEntity;
import com.hireme.user.service.ParentService;
import com.hireme.user.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/getParentByName/{name}")
    public List<ParentEntity> findParentByName(@PathVariable String name) {
        name = name.replace("+", " ");
        return parentService.findParentByName(name);

    }
}