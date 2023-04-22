package com.octanom.poc.dashboard.service;

import com.octanom.poc.dashboard.domain.Student;
import com.octanom.poc.dashboard.repository.StudentData;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    private final StudentData studentData;

    @Override
    public List<Student> getStudentData() {
        return this.studentData.getStudents();
    }
}
