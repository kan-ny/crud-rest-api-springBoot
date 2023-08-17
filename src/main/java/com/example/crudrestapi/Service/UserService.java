package com.example.crudrestapi.Service;

import com.example.crudrestapi.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getUsers();
    User updateUser(User user);
    String deleteUserById(Long id);
}
