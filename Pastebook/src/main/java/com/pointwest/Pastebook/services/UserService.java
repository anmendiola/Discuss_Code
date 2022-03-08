package com.pointwest.Pastebook.services;

import com.pointwest.Pastebook.models.User;

import java.util.Optional;

public interface UserService {

    // Create user
    void createUser (User user);

    //Login
    Optional<User> findByEmail(String email);
    Iterable<User> verifyUser(String email, String key);


}
