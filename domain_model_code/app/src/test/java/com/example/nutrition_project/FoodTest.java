package com.example.nutrition_project;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class FoodTest {
    Food f;
    @Before
    public void createFood(){
        f=new Food("biscuits",50,119,7.6,45,.2,.8);
    }
    @Test
    public void checkHashNotNUll(){
           Assert.assertNotNull(f.getFoodConsumptions());
    }
    @Test
    public void checkFoodConsumptions(){
        f.addFoodConsumption(new FoodConsumption(5,"BreakFast"));
        f.addFoodConsumption(new FoodConsumption(6,"Lunch"));
       Assert.assertTrue( f.how_many_foods()==11);
    }

}