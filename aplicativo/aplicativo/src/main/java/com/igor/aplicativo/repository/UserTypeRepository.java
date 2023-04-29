package com.igor.aplicativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.aplicativo.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long>{

}
