package com.CrimeReporting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CrimeReporting.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.user_email = :user_email")
    User getUserByUserName(@Param("user_email") String user_email);
}
