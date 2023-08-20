package com.example.crudrestapi.Repository;

import com.example.crudrestapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    // Qurey Creation

    // https://www.baeldung.com/spring-data-derived-queries

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation

    Optional<User> findByEmail(String email);
}
