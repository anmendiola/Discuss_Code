package com.pointwest.Pastebook.services;


import com.pointwest.Pastebook.models.User;
import com.pointwest.Pastebook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    //Create user
    public void createUser(User user) {

        userRepository.save(user);}

    // Login

    public Optional<User> findByEmail(String email){
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    public Iterable<User> verifyUser(String email, String key){
        ArrayList<User> info = new ArrayList<>();
        info.add(userRepository.findByEmail(email));
        key = userRepository.findByEmail(email).getPassword();
        return info;
    }
}
