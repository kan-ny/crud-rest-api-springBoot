package com.example.crudrestapi.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

        private Long id;

        @NotEmpty (message = "Dude firstName cant't be empty :/ ")
        private String firstName;
        @NotEmpty (message = "Dude LastName cant't be empty :( ")
        private String lastName;
        @NotEmpty (message = "Email cant't be empty!")
        @Email(message = "Email is not Valid :(")
        private String Email;


    }