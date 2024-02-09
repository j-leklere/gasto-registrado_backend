package com.example.gastoregistrado.controller;

import com.example.gastoregistrado.dto.UserDto;
import com.example.gastoregistrado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createUser", method = {RequestMethod.POST})
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body("User created successfully!");
    }
}
