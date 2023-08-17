package com.example.crudrestapi.Controller;

import com.example.crudrestapi.Dto.UserDto;
import com.example.crudrestapi.Entity.User;
import com.example.crudrestapi.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>( userService.createUser(userDto), HttpStatus.CREATED);
    }

//    @GetMapping("{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id){
//        return ResponseEntity.ok(userService.getUserById(id));
//    }
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        System.out.println("put request..");
        return ResponseEntity.ok(userService.updateUser(userDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

}
