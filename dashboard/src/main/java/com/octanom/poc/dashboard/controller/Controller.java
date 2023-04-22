package com.octanom.poc.dashboard.controller;

import com.octanom.poc.dashboard.domain.Student;
import com.octanom.poc.dashboard.service.Service;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("")
public class Controller {

    private final Service service;

    @GetMapping("/students")
    @CrossOrigin("*")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(service.getStudentData(), HttpStatus.OK);
    }
}
