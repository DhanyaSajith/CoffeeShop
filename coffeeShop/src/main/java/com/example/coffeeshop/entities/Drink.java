package com.example.coffeeshop.entities;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @OneToMany(mappedBy = "drink")
    private List<DrinkTopping> toppings;

    public Drink(Long id, String name, double price, List<DrinkTopping> toppings) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.toppings = toppings;
    }

    public Drink() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<DrinkTopping> getToppings() {
        return toppings;
    }

    public void setToppings(List<DrinkTopping> toppings) {
        this.toppings = toppings;
    }

    // getters and setters
}