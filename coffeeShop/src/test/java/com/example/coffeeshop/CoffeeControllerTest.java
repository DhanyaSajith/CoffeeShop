package com.example.coffeeshop.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.coffeeshop.entities.Drink;
import com.example.coffeeshop.repository.DrinkRepository;
import com.example.coffeeshop.repository.DrinkToppingRepository;
import com.example.coffeeshop.repository.ToppingRepository;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeControllerTest {

    @InjectMocks
    private CoffeeController coffeeController;

    @Mock
    private DrinkRepository drinkRepository;

    @Mock
    private ToppingRepository toppingRepository;

    @Mock
    private DrinkToppingRepository drinkToppingRepository;

    @Before("execution(* com.example.coffeeshop.controllers.CoffeeControllerTest.*(..))")
    public void setUp() {
    }

    @Test
    public void testGetAllDrinks() {
        Drink drink1 = new Drink();
        drink1.setId(1L);
        drink1.setName("Latte");
        drink1.setPrice(5.0);

        Drink drink2 = new Drink();
        drink2.setId(2L);
        drink2.setName("Mocha");
        drink2.setPrice(6.0);

        List<Drink> drinks = new ArrayList<>();
        drinks.add(drink1);
        drinks.add(drink2);

        Mockito.when(drinkRepository.findAll()).thenReturn(drinks);

        List<Drink> result = coffeeController.getAllDrinks();

        assertEquals(2, result.size());
        assertEquals("Latte", result.get(0).getName());
        assertEquals(5.0, result.get(0).getPrice(), 0.0);
        assertEquals("Mocha", result.get(1).getName());
        assertEquals(6.0, result.get(1).getPrice(), 0.0);
    }

    @Test
    public void testCreateDrink() {
        Drink drink = new Drink();
        drink.setId(1L);
        drink.setName("Latte");
        drink.setPrice(5.0);

        Mockito.when(drinkRepository.save(Mockito.any(Drink.class))).thenReturn(drink);

        Drink result = coffeeController.createDrink(drink);

        assertEquals(1L, result.getId().longValue());
        assertEquals("Latte", result.getName());
        assertEquals(5.0, result.getPrice(), 0.0);
    }

    @Test
    public void testUpdateDrink() {
        Drink drink = new Drink();
        drink.setId(1L);
        drink.setName("Latte");
        drink.setPrice(5.0);

        Optional<Drink> optionalDrink = Optional.of(drink);

        Mockito.when(drinkRepository.findById(1L)).thenReturn(optionalDrink);

        Drink updatedDrink = new Drink();
        updatedDrink.setId(1L);
        updatedDrink.setName("Mocha");
        updatedDrink.setPrice(6.0);

        Mockito.when(drinkRepository.save(Mockito.any(Drink.class))).thenReturn(updatedDrink);

        ResponseEntity<Drink> result = coffeeController.updateDrink(1L, updatedDrink);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Mocha", result.getBody().getName());
        assertEquals(6.0, result.getBody().getPrice(), 0.0);
    }

    @Test
    public void testDeleteDrink() {
        Drink drink = new Drink();
        drink.setId(1L);
        drink.setName("Latte");
        drink.setPrice(5.0);

        Optional<Drink> optionalDrink = Optional.of(drink);

        Mockito.when(drinkRepository.findById(1L)).thenReturn(optionalDrink);

        ResponseEntity<Void> result = coffeeController.deleteDrink(1L);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }
    
}