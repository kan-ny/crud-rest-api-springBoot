package com.example.crudrestapi.Service;

import com.example.crudrestapi.Dto.UserDto;
import com.example.crudrestapi.Entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getUsers();
    UserDto updateUser(UserDto userDto);
    String deleteUserById(Long id);
}
