package com.example.crudrestapi.Service;

import com.example.crudrestapi.Entity.User;
import com.example.crudrestapi.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplimentation implements UserService {

    private UserRepository userRepository;

    public UserServiceImplimentation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUsers() {
        return  userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User current_user= userRepository.findById(user.getId()).get();
        System.out.println(current_user.toString());
        System.out.println("test....");
        current_user.setEmail(user.getEmail());
        current_user.setFirstName(user.getFirstName());
        current_user.setLastName(user.getLastName());

        return userRepository.save(current_user);

    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id+" User deleted!";
    }
}
