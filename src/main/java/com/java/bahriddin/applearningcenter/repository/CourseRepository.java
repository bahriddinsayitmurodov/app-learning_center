package com.java.bahriddin.applearningcenter.repository;

import com.java.bahriddin.applearningcenter.entity.Course;
import com.java.bahriddin.applearningcenter.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends GenericRepository<Course,Integer> {
}

