package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.user;
import com.example.demo.domain.repository.PGUserRepository;

@Service
public class UserService {

    private final PGUserRepository userRepository = new PGUserRepository();

    private final List<user> users = new ArrayList<>();

    public void addUser(user u){
        users.add(u);
        userRepository.addUser(u);
    } 

    public String deleteUser(int id){
        users.removeIf(user -> user.getId() == id);
        user u = userRepository.getUser(id);
        if (u != null) {
            userRepository.deleteUser(u);
            return "Successfuly deleted user";
        } else {
            return "User not found!";
        }
    }

    public String getUser(int id){
        user u = userRepository.getUser(id);
        if (u == null) return "User not found!";
        return "Users details: " + "Name: "+ u.getName() + " Bench press: "  + u.getBenchPress(); 
    }

    public String updateUser(int id){
        users.removeIf(user -> user.getId() == id);
        user u = userRepository.getUser(id);
        if (u != null) {
            userRepository.updateUser(u);
            return "Successfuly updated user";
        } else {
            return "User not found!";
        }
    }
}
