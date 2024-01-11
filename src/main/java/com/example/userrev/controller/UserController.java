package com.example.userrev.controller;

import com.example.userrev.Model.User;
import com.example.userrev.dto.UserDto;
import com.example.userrev.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

 @Autowired
 private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{userId}")
    public ResponseEntity<Optional<User>> getByUserid(@PathVariable  long userId)  {

        return ResponseEntity.ok(userService.findUserById(userId));
    }
    @ResponseStatus(HttpStatus.OK)
     @GetMapping("/allUsers")
    public ResponseEntity<List<User>>getAllUsers(){

        return new ResponseEntity<>(userService.getUserList(), HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/adduser")
    public ResponseEntity<User>signUpUser(@RequestBody @Valid UserDto user){

        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete{userId}")
    public Map<String,String> deleteUser(@RequestParam long userId) {

        return userService.deleteUserById(userId);


    }






}
