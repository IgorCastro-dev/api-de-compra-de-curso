package com.igor.aplicativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.aplicativo.model.SubscriptionsType;

@Repository
public interface SubscriptionsTypeRepository extends JpaRepository<SubscriptionsType, Long>{

}
