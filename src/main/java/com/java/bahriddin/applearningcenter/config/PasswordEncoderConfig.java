package uz.pdp.springsecuritystarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder encoder(){
        //return  NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder(8);
    }
}
