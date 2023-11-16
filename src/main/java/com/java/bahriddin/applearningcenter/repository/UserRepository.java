package com.java.bahriddin.applearningcenter.repository;

import com.java.bahriddin.applearningcenter.entity.User;
import com.java.bahriddin.applearningcenter.enums.Role;
import com.java.bahriddin.applearningcenter.generic.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<List<User>> findAllByRoleEquals(Role role);

}
