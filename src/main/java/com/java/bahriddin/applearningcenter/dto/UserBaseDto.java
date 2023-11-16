package com.java.bahriddin.applearningcenter.dto;

import com.java.bahriddin.applearningcenter.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseDto {

    @NotBlank(message = "auth.user.name.required")
    private String name;

    @NotBlank(message = "auth.username.required")
    private String username;

    @Email(message = "auth.email.required")
    private String email;

    @NotBlank(message = "auth.user.phoneNumber.required")
    @Pattern(regexp = "^(\\+998)\\d{9}", message = "pattern.phone.number")
    private String phone;

}
