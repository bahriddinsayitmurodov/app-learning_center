package com.java.bahriddin.applearningcenter.generic;

public abstract class GenericModelMapper<ENTITY, CREATE_DTO, RESPONSE_DTO, UPDATE_DTO> {
    public abstract ENTITY toEntity(CREATE_DTO createDto);
    public abstract RESPONSE_DTO toResponse(ENTITY entity);
    public abstract void update(UPDATE_DTO updateDto, ENTITY entity);
}
