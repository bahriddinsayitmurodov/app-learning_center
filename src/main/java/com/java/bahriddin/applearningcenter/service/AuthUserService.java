package com.java.bahriddin.applearningcenter.service;

import com.java.bahriddin.applearningcenter.dto.AuthUserDto;
import com.java.bahriddin.applearningcenter.entity.authuser.AuthUser;
import com.java.bahriddin.applearningcenter.enums.Role;
import com.java.bahriddin.applearningcenter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.List;


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
        System.out.println("authUser = " + authUser);
        return new User(authUser.getUsername(),authUser.getPassword(), authUser.getAuthorities());
    }

    public void create(AuthUserDto userDto) {

        AuthUser authUser = mapper.map(userDto, AuthUser.class);
        authUser.setRole(Role.MENTOR);
        userRepository.save(authUser);
    }


    public List<AuthUser> getAllMentors() {
        List<AuthUser> allUsers = userRepository.findAll();

//        return allUsers.stream().filter(authUser -> authUser.getRole().toString().equals("MENTOR")).toList();

        return allUsers;


    }
}
