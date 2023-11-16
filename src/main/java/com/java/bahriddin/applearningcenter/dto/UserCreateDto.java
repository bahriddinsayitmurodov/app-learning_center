package com.java.bahriddin.applearningcenter.dto;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class UserCreateDto extends UserBaseDto{
    @NotBlank
    private String password;
}
