package com.example.coffeeshop.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @OneToMany(mappedBy = "topping")
    private List<DrinkTopping> drinks;

    // getters and setters
    public Topping(Long id, String name, double price, List<DrinkTopping> drinks) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.drinks = drinks;
    }

    public Topping() {
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

    public List<DrinkTopping> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<DrinkTopping> drinks) {
        this.drinks = drinks;
    }
}
