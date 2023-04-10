package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    
// Signup
public void signUp(User user) throws Exception {
    // validate user data
    if(userRepository.existsById(user.getId())) {
        throw new Exception("User already exists");
    }
    // save user to database
    userRepository.save(user);
}

// Login
public String login(User user) throws Exception {
    // authenticate user
    User existingUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    if(existingUser == null) {
        throw new Exception("User does not exist");
    }
    if(!existingUser.getPassword().equals(user.getPassword())) {
        throw new Exception("Incorrect password");
    }
    // return access token or error message
    return "Access token";
}

}
