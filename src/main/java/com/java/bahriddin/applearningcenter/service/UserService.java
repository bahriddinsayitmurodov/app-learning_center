package com.java.bahriddin.applearningcenter.service;

import com.java.bahriddin.applearningcenter.dto.UserCreateDto;
import com.java.bahriddin.applearningcenter.dto.UserResponseDto;
import com.java.bahriddin.applearningcenter.dto.UserUpdateDto;
import com.java.bahriddin.applearningcenter.entity.User;
import com.java.bahriddin.applearningcenter.enums.Role;
import com.java.bahriddin.applearningcenter.generic.GenericCrudService;
import com.java.bahriddin.applearningcenter.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class UserService extends GenericCrudService<User,Integer, UserCreateDto, UserResponseDto, UserUpdateDto> {
    private final UserRepository repository;
    private final UserModelMapper mapper;

    public List<User> getAllStudents(){
        return repository.findAllByRoleEquals(Role.STUDENT).orElse(null);
    }
}
