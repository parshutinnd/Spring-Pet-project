package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entity.user;
import com.example.demo.service.UserService;




@RestController
public class UserController {

    private final static UserService userService = new UserService();
    
    @PostMapping("/add/name/{name}/benchPress/{benchPress}")
    public static void  createUser(@PathVariable String name, @PathVariable int benchPress){
        user u = new user(name, benchPress);
        userService.addUser(u);
    }

    @GetMapping("/user/id/{id}")
    @ResponseBody
    public static String getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/id/{id}")
    @ResponseBody
    public static void  deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
    
    @PutMapping("/update/id/{id}")
    public String uspdateUser(@PathVariable int id) {
        return userService.updateUser(id);
    }
    
}
