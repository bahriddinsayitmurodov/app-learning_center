package com.java.bahriddin.applearningcenter.repository;

import com.java.bahriddin.applearningcenter.entity.authuser.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Integer> {
    Optional<AuthUser> getAuthUserByUsername(String username);
}
