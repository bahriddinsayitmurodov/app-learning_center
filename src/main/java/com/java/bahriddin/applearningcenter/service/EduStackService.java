package com.java.bahriddin.applearningcenter.service;

import com.java.bahriddin.applearningcenter.entity.Course;
import com.java.bahriddin.applearningcenter.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EduStackService {

    private final CourseRepository stackRepository;


    public List<Course> getAll() {
        return  stackRepository.findAll();
    }

    public void create(Course stack) {
        stackRepository.save(stack);
    }

    public void deleteById(Integer id) {
        stackRepository.deleteById(id);
    }
}
