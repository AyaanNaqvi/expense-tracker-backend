package org.example.expense;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRep extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}

