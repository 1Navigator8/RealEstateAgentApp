package com.example.realestateagentapp.repository;

import com.example.realestateagentapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    public Optional<Users> findByUserEmail(String email);

}
