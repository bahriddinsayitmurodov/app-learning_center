package com.java.bahriddin.applearningcenter.entity.student;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    private String stack;

    @Column(nullable = false)
    private LocalDate birthDate;


/*
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_stacks",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "stack_id")
    )
    private List<EduStack> stacks;*/
}
