package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeeshop.entities.Topping;

@Repository
public interface ToppingRepository extends JpaRepository <Topping,Long> {
}
