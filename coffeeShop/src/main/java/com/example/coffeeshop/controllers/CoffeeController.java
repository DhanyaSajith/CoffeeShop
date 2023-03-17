package com.example.coffeeshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeeshop.entities.Drink;
import com.example.coffeeshop.entities.Topping;
import com.example.coffeeshop.repository.DrinkRepository;
import com.example.coffeeshop.repository.DrinkToppingRepository;
import com.example.coffeeshop.repository.ToppingRepository;

@RestController
@RequestMapping("/api")
public class CoffeeController {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private DrinkToppingRepository drinkToppingRepository;

    // Endpoint to get all drinks
    @GetMapping("/drinks")
    public List<Drink> getAllDrinks(){
        return drinkRepository.findAll();
    }
    // Endpoint to add a drink
    @PostMapping("/drinks")
    public Drink createDrink(@RequestBody Drink drink){
        return drinkRepository.save(drink);
    }
    // Endpoint to update a drink
    @PutMapping("/drinks/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable Long id, @RequestBody Drink drinkDetails) {
        Optional<Drink> drink = drinkRepository.findById(id);
        if (drink.isPresent()) {
            Drink updatedDrink = drink.get();
            updatedDrink.setName(drinkDetails.getName());
            updatedDrink.setPrice(drinkDetails.getPrice());
//            updatedDrink.setTopping(drinkDetails.getTopping());
            drinkRepository.save(updatedDrink);
            return ResponseEntity.ok(updatedDrink);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Endpoint to delete a drink
    @DeleteMapping("/drinks/{id}")
    public ResponseEntity<Void> deleteDrink(@PathVariable Long id) {
        Optional<Drink> drink = drinkRepository.findById(id);
        if (drink.isPresent()) {
            drinkRepository.delete(drink.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Endpoint to get all toppings
    @GetMapping("/toppings")
    public List<Topping> getAllToppings() {
        return toppingRepository.findAll();
    }
    // Endpont to add a topping
    @PostMapping("/toppings")
    public Topping createTopping(@RequestBody Topping topping) {
        return toppingRepository.save(topping);
    }
    // Endpoint to update a topping
    @PutMapping("/toppings/{id}")
    public ResponseEntity<Topping> updateTopping(@PathVariable Long id, @RequestBody Topping toppingDetails) {
        Optional<Topping> topping = toppingRepository.findById(id);
        if (topping.isPresent()) {
            Topping updatedTopping = topping.get();
            updatedTopping.setName(toppingDetails.getName());
            updatedTopping.setPrice(toppingDetails.getPrice());
            toppingRepository.save(updatedTopping);
            return ResponseEntity.ok(updatedTopping);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Enpoint to delete a topping
    @DeleteMapping("/toppings/{id}")
    public ResponseEntity<Void> deleteTopping(@PathVariable Long id) {
        Optional<Topping> topping = toppingRepository.findById(id);
        if (topping.isPresent()) {
            toppingRepository.delete(topping.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
