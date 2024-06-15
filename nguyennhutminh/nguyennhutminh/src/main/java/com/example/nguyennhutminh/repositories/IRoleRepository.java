package com.example.nguyennhutminh.repositories;

import com.example.nguyennhutminh.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
}
