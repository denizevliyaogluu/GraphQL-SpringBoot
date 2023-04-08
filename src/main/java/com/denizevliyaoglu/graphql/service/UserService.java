package com.denizevliyaoglu.graphql.service;

import com.denizevliyaoglu.graphql.exception.UserNotFoundException;
import com.denizevliyaoglu.graphql.model.User;
import com.denizevliyaoglu.graphql.model.UserRequest;
import com.denizevliyaoglu.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
    }
    public User createUser(UserRequest userRequest){
        User user = User.builder()
                .username(userRequest.getUsername())
                .phoneNumber(userRequest.getPhoneNumber())
                .role(userRequest.getRole())
                .build();
        return userRepository.save(user);
    }
    public User updateUser(UserRequest userRequest){
        User existing = getUserById(userRequest.getId());
        existing.setRole(userRequest.getRole());
        existing.setUsername(userRequest.getUsername());
        existing.setPhoneNumber(userRequest.getPhoneNumber());
        return userRepository.save(existing);
    }
    public void deleteUser(Long id){
        User existing = getUserById(id);
        userRepository.delete(existing);
    }

}
