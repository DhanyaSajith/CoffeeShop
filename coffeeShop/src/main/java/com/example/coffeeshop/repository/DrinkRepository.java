package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeeshop.entities.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long>{

}
