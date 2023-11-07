package uz.pdp.springsecuritystarter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthUserDto {

    private String name;

    private String username;

    private String password;

    private String email;

    private String phone;
}
