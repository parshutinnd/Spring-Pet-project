package com.example.demo.domain.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.user;

@Repository
public interface IUserRepository {
    
    void addUser(user u);
    void deleteUser(user u);
    user getUser(int id);
    void updateUser(user u);
}
