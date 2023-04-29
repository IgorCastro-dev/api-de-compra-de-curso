package com.igor.aplicativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.aplicativo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
