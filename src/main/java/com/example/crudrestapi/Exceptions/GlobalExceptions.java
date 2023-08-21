package com.example.crudrestapi.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
// ResponseEntityExceptionHandler is for Validatian Exceptions
public class GlobalExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<ErrorDetails> emailExistException(EmailExistException emailExistException,
                                                            WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                webRequest.getDescription(false),
                emailExistException.getMessage(),
                "User_Email_Already_Exist"
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException
                                                                              resourceNotFoundException,
                                                                  WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                webRequest.getDescription(false),
                resourceNotFoundException.getMessage(),
                "No Resource Found"
                );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> globalException(Exception exception,
                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                webRequest.getDescription(false),
                exception.getMessage(),
                "No Resource Found.... haha, LOL"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatusCode status,
                                                               WebRequest request) {

        Map<String, String> error = new HashMap<>();
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        errorList.forEach(e->{
            String fieldName = ( (FieldError) e ).getField();
            String msg = e.getDefaultMessage();
            error.put(fieldName, msg);
        });
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}
