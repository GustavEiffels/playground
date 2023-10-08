package com.example.demo.user.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.user.dto.User;

public interface UserRepository extends JpaRepository<User,UUID>
{
    List<User> findAllUserById(String userId);
}
