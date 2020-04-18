package com.rk.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.example.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
