package com.igor.aplicativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.aplicativo.model.UserPaymentInfo;

@Repository
public interface UserPaymentInfoRepository extends JpaRepository<UserPaymentInfo, Long>{

}
