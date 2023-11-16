package com.java.bahriddin.applearningcenter.service;

import com.java.bahriddin.applearningcenter.dto.UserCreateDto;
import com.java.bahriddin.applearningcenter.dto.UserResponseDto;
import com.java.bahriddin.applearningcenter.dto.UserUpdateDto;
import com.java.bahriddin.applearningcenter.entity.User;
import com.java.bahriddin.applearningcenter.generic.GenericModelMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserModelMapper extends GenericModelMapper<User, UserCreateDto, UserResponseDto, UserUpdateDto> {

    private final ModelMapper mapper;

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return mapper.map(userCreateDto,User.class);
    }

    @Override
    public UserResponseDto toResponse(User user) {
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public void update(UserUpdateDto userUpdateDto, User user) {
        mapper.map(userUpdateDto,user);
    }
}
