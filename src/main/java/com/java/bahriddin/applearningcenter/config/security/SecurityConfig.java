package com.java.bahriddin.applearningcenter.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthUserDetailsService userService;
    private final CustomFailureHandler failureHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

        security.csrf(AbstractHttpConfigurer::disable);

        security.authorizeHttpRequests(
                authorization -> authorization.requestMatchers("/auth/login", "/css/**",
                                "/fonts/**",
                                "/image/**",
                                "/js/**",
                                "/scss.bootstrap/**","/auth/register", "/home", "/css/**", "/image/**")
                        .permitAll()
                        /*.requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/manager").hasRole("MANAGER")*/
                        .anyRequest()
                        .authenticated()
        );

        security.formLogin(
                login->login.loginPage("/auth/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)
                        .failureHandler(failureHandler)
        );
        // for getting user details from database
        security.userDetailsService(userService);

        security.rememberMe(remember ->
                remember.rememberMeParameter("rememberMe")
                        .key("@NJFEN34ef4fnejfnr%^T%#%")
                        .tokenValiditySeconds(86400)
                        .rememberMeCookieName("rememberMe")
        );

        return security.build();
    }


   /*
   // for saving user details in RAM
   @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin = User.withDefaultPasswordEncoder().roles("ADMIN").username("bahriddin").password("123").build();
        UserDetails user = User.withDefaultPasswordEncoder().roles("USER").username("AZIM").password("123").build();
       return new InMemoryUserDetailsManager(ad
       min, user);
    }*/
}
