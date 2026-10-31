package com.travel.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}