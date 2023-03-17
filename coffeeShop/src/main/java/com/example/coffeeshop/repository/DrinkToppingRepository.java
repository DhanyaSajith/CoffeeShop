package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeeshop.entities.DrinkTopping;

@Repository
public interface DrinkToppingRepository extends JpaRepository<DrinkTopping,Long> {
}
