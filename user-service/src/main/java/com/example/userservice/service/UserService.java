package com.example.userservice.service;

import com.example.userservice.entity.User;

import java.util.List;

public interface UserService {
    public User getUserProfile(String jwt);
    public List<User>getAllUsers();
}
