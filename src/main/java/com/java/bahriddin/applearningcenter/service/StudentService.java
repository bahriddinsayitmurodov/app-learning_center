package com.java.bahriddin.applearningcenter.service;

import com.java.bahriddin.applearningcenter.dto.AuthUserDto;
import com.java.bahriddin.applearningcenter.entity.authuser.AuthUser;
import com.java.bahriddin.applearningcenter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = userRepository
                .getAuthUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return new User(authUser.getUsername(),authUser.getPassword(), authUser.getAuthorities());
    }

    public void create(AuthUserDto userDto) {
        System.out.println(userDto);

        AuthUser authUser = mapper.map(userDto, AuthUser.class);
        authUser.setPassword(encoder.encode(authUser.getPassword()));

        System.out.println(authUser);
        userRepository.save(authUser);
    }

}
