package com.java.bahriddin.applearningcenter.service;

import com.java.bahriddin.applearningcenter.dto.StudentDto;
import com.java.bahriddin.applearningcenter.entity.stack.EduStack;
import com.java.bahriddin.applearningcenter.entity.student.Student;
import com.java.bahriddin.applearningcenter.repository.EduStackRepository;
import com.java.bahriddin.applearningcenter.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final EduStackRepository stackRepository;

    public List<Student> getAll() {
        return  studentRepository.findAll();
    }

    @Transactional
    public void create(StudentDto studentDto) {

        String stack = studentDto.getStack();
        EduStack eduStack = stackRepository.findByName(stack);

        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .phone(studentDto.getPhone())
                .stack(studentDto.getStack())
                .email(studentDto.getEmail())
                .birthDate(studentDto.getBirthDate())
                .build();

        studentRepository.save(student);




        /*
                .name(studentDto.getName())
                .phone(studentDto.)
                .role(Role.STUDENT)
                .email(studentDto.getEmail())
                .stacks(new ArrayList<>() {{

                    add(eduStack);
                }})
                .build();
*/
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student getById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    @Transactional
    public void update(Integer id, StudentDto studentDto) {

        Student student = studentRepository.findById(id).get();

        student.setPhone(Objects.requireNonNullElse(studentDto.getPhone(),student.getPhone()));
        student.setFirstName(Objects.requireNonNullElse(studentDto.getFirstName(),student.getFirstName()));
        student.setLastName(Objects.requireNonNullElse(studentDto.getLastName(),student.getLastName()));
        student.setBirthDate(Objects.requireNonNullElse(studentDto.getBirthDate(),student.getBirthDate()));
        student.setEmail(Objects.requireNonNullElse(studentDto.getEmail(),student.getEmail()));

        studentRepository.save(student);
    }
}
