package com.example.team13_nutrition;

import org.junit.Assert;
import org.junit.Test;

public class FoodConsumptionTest {
    public FoodConsumption fc;
     @Test
     public void checkDateIsNotNull(){
         fc = new FoodConsumption(5, "Breakfast", new Food("Beans", 100, 4.5, 8.7, 11, 2));
         Assert.assertNotNull(fc.getDate());
     }
     @Test
    public void check(){
         FoodConsumption[] fc = new FoodConsumption[3];
         fc[0] = new FoodConsumption(5, "Breakfast", new Food("Biscuits", 100, 4.5, 8.7, 11, 2));
         fc[1] = new FoodConsumption(10, "Lunch", new Food("Hamburger", 100, 4.5, 8.7, 11, 2));
         fc[2] = new FoodConsumption(15, "Dinner", new Food("Steak", 100, 4.5, 8.7, 11, 2));
         Assert.assertEquals(fc[0].getMealType(), FoodConsumption.MealType.Breakfast);
         Assert.assertEquals(fc[1].getMealType(), FoodConsumption.MealType.Lunch);
         Assert.assertEquals(fc[2].getMealType(), FoodConsumption.MealType.Dinner);
     }
}