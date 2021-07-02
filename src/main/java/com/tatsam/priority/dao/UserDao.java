package com.tatsam.priority.dao;

import com.tatsam.priority.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
}
