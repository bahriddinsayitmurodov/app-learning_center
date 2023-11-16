package com.java.bahriddin.applearningcenter.generic;

import com.java.bahriddin.applearningcenter.exceptions.EntityNotFoundException;

import java.util.List;

public abstract class GenericCrudService <ENTITY, ID, CREATE_DTO, RESPONSE_DTO, UPDATE_DTO>{
     protected abstract GenericRepository<ENTITY, ID> getRepository();
     protected abstract GenericModelMapper<ENTITY, CREATE_DTO, RESPONSE_DTO, UPDATE_DTO> getMapper();


     public RESPONSE_DTO create(CREATE_DTO createDto){
          ENTITY entity = getMapper().toEntity(createDto);
          ENTITY saved = getRepository().save(entity);
          return getMapper().toResponse(saved);
     }

     public RESPONSE_DTO getById(ID id){
          ENTITY entity = getRepository()
                  .findById(id).
                  orElseThrow(() -> new EntityNotFoundException("entity with id = '%s' not found".formatted(id)));
          return getMapper().toResponse(entity);
     }

     public List<RESPONSE_DTO> getAll(){
          List<ENTITY> entities = getRepository().findAll();
          return entities.stream().
                  map(entity -> getMapper().toResponse(entity)).toList();
     }

     public void delete(ID id){
          ENTITY entity = getRepository()
                  .findById(id).
                  orElseThrow(() -> new EntityNotFoundException("entity with id = '%s' not found".formatted(id)));

          getRepository().deleteById(id);
     }

     public RESPONSE_DTO update(ID id, UPDATE_DTO updateDto){
          ENTITY entity = getRepository()
                  .findById(id).
                  orElseThrow(() -> new EntityNotFoundException("entity with id = '%s' not found".formatted(id)));

          getMapper().update(updateDto,entity);
          ENTITY saved = getRepository().save(entity);
          return getMapper().toResponse(saved);
     }


}
