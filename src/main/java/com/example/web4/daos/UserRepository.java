package com.example.web4.daos;

import com.example.web4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User save(User user);
    Optional<User> findByUsername(String username);
}
