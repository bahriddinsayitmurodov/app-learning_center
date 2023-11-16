package com.java.bahriddin.applearningcenter.dto;

import com.java.bahriddin.applearningcenter.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto extends UserBaseDto {

    private Integer id;

    private Role role;

    private LocalDateTime createdAt;
}
