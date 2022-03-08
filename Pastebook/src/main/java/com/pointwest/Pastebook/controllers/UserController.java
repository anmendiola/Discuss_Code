package com.pointwest.Pastebook.controllers;

import com.pointwest.Pastebook.models.User;
import com.pointwest.Pastebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin

public class UserController {
    @Autowired
    UserService userService;

    //Create User
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user){

        userService.createUser(user);
        return new ResponseEntity<>("User   created successfully.", HttpStatus.CREATED);
    }

    //Login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ResponseEntity<Object> verifyUser(@RequestBody Map<String, String> body, String key){
        String email = body.get("email");
        if (userService.findByEmail(email).isPresent()){
            String input = body.get("password");
            if (key.equals(input)) {
                return new ResponseEntity<>("User successfully logged-in", HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity<>("Invalid credentials.", HttpStatus.BAD_REQUEST);
            }
        } else{
            return new ResponseEntity<>("User does not exist.", HttpStatus.BAD_REQUEST);
        }
    }




}
