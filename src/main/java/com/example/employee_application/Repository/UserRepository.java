package com.example.employee_application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_application.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
