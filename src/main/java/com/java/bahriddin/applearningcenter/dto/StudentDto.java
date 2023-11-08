package com.java.bahriddin.applearningcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private LocalDate birthDate;

    private String stack;

}
