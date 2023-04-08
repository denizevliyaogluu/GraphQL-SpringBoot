package com.denizevliyaoglu.graphql.controller;

import com.denizevliyaoglu.graphql.model.User;
import com.denizevliyaoglu.graphql.model.UserRequest;
import com.denizevliyaoglu.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping
    User getUserById(Long id){
        return userService.getUserById(id);
    }
    @PostMapping
    User createUser(UserRequest userRequest){
        return userService.createUser(userRequest);
    }
    @PutMapping
    User updateUser(UserRequest userRequest){
        return userService.updateUser(userRequest);
    }

    @DeleteMapping
    Boolean deleteUser(Long id){
        userService.deleteUser(id);
        return true;
    }





}
