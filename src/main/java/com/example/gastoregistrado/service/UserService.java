package com.example.gastoregistrado.service;

import com.example.gastoregistrado.dao.UserDao;
import com.example.gastoregistrado.dto.UserDto;
import com.example.gastoregistrado.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void createUser(UserDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAvatar(userDto.getAvatar());
        user.setRole(userDto.getRole());
        user.setState(userDto.getState());

        user.onCreate();

        userDao.save(user);
    }
}
