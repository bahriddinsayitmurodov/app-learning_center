package com.java.bahriddin.applearningcenter.repository;

import com.java.bahriddin.applearningcenter.entity.stack.EduStack;
import com.java.bahriddin.applearningcenter.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EduStackRepository extends JpaRepository<EduStack,Integer> {
    EduStack findByName(String name);
}
