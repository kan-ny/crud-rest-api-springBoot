package com.example.crudrestapi.Service;

import com.example.crudrestapi.Dto.UserDto;
import com.example.crudrestapi.Entity.User;
import com.example.crudrestapi.Mapper.UserMapper;
import com.example.crudrestapi.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImplimentation implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

//    public UserServiceImplimentation(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDto createUser(UserDto userDto) {

//        User user = new User();
//        user.setEmail(userDto.getEmail());
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//
//        User savedUser = userRepository.save(user);
//
//        return new UserDto(
//                savedUser.getId(),
//                savedUser.getFirstName(),
//                savedUser.getLastName(),
//                savedUser.getEmail()
//        );


        //using Mapper

//      User savedUser = userRepository.save( UserMapper.mapToUser(userDto));
//      return UserMapper.mapToUserDto(savedUser);

//       Using Mapper Model Lib

        User us = userRepository.save( modelMapper.map(userDto, User.class) );
        return modelMapper.map(us, UserDto.class);


    }

    @Override
    public UserDto getUserById(Long id) {

        User u = userRepository.findById(id).get();
//        UserDto ud = new UserDto(
//                u.getId(),
//                u.getFirstName(),
//                u.getLastName(),
//                u.getEmail()
//        );
//        return  ud;
//        return UserMapper.mapToUserDto(u);

//       Using Mapper Model Lib
        return modelMapper.map(u, UserDto.class);

    }

    @Override
    public List<UserDto> getUsers() {
        List<User> l = userRepository.findAll();
//        return l.stream().map( UserMapper::mapToUserDto ).collect(Collectors.toList());

        //       Using Mapper Model Lib
        return l.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User current_user= userRepository.findById(userDto.getId()).get();
        System.out.println(current_user.toString());
        System.out.println("test....");
        current_user.setEmail(userDto.getEmail());
        current_user.setFirstName(userDto.getFirstName());
        current_user.setLastName(userDto.getLastName());

        User updateUser = userRepository.save(current_user);
//        return UserMapper.mapToUserDto(updateUser);


    //       Using Mapper Model Lib
        return modelMapper.map(updateUser, UserDto.class);

    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id+" User deleted!";
    }
}
