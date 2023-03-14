package com.example.web4.daos;

import com.example.web4.entities.Shot;
import com.example.web4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShotRepository extends JpaRepository<Shot, Long> {
//    List<Shot> findAllByCreator(User user);
}
