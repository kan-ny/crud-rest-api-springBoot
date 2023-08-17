package com.example.crudrestapi.Mapper;

import com.example.crudrestapi.Dto.UserDto;
import com.example.crudrestapi.Entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static User mapToUser(UserDto userDto){
        User u = new User();
        u.setId(userDto.getId());
        u.setEmail(userDto.getEmail());
        u.setFirstName(userDto.getFirstName());
        u.setLastName(userDto.getLastName());
        return u;
    }
}
