package com.java.bahriddin.applearningcenter.repository;

import com.java.bahriddin.applearningcenter.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
