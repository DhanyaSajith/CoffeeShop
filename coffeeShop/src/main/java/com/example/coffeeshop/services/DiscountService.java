
package com.example.coffeeshop.services;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DiscountService 
{
//Calculate the total price of all Items

    public double calculateDiscount(List<OrderItem> items) {
        double total = calculateTotal(items);
        double discount = 0.0;

        if (total >= 12.0) {
            discount = total * 0.25;
        }

        if (hasFreeDrink(items)) {
            double lowestPrice = getLowestDrinkPrice(items);
            discount += lowestPrice;
        }

        return discount;
    }

 //Calculate if eliglible for promotion

       private double calculateTotal(List<OrderItem> items) {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    private boolean hasFreeDrink(List<OrderItem> items) {
        return items.size() >= 3;
    }
//Calculate the drinkwithtopping with the lowest price

    private double getLowestDrinkPrice(List<OrderItem> items) {
        double lowestPrice = Double.MAX_VALUE;
        for (OrderItem item : items) {
            if (item.getType() == ItemType.DRINK && item.getPrice() < lowestPrice) {
                lowestPrice = item.getPrice();
            }
        }
        return lowestPrice;
    }
}


 /* In this implementation, the calculateDiscount method takes a list of OrderItems and returns the total discount amount to be applied. The method first calculates the total price of all items in the cart. Then, it checks if the cart is eligible for the 25% discount (if the total is greater than or equal to 12.0). If so, it applies the discount to the total.
Next, the method checks if the cart is eligible for the free drink promotion (if there are three or more drinks in the cart). If so, it finds the drink with the lowest price (including toppings) and adds its price to the discount.
Finally, the method returns the total discount amount to be applied. */