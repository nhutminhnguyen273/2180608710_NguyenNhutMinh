package com.example.nguyennhutminh.repositories;

import com.example.nguyennhutminh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
