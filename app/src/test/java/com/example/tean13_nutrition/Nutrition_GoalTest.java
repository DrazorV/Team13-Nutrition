package com.example.tean13_nutrition;
import com.example.tean13_nutrition.Nutrition_Goal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Nutrition_GoalTest {
    Nutrition_Goal ng;

    @Before
    public void create(){
        ng=new Nutrition_Goal("Maintain_Weight",10);
    }
    @Test
    public void checkNutritionGoal() {
        Nutrition_Goal ng[]=new Nutrition_Goal[3];
        ng[0]=new Nutrition_Goal("Maintain_Weight",10);
        ng[1]=new Nutrition_Goal("Weight_Loss",10);
        ng[2]=new Nutrition_Goal("Gain_Weight",10);
        Assert.assertEquals(ng[0].getGoal_Type(), Nutrition_Goal.Nutrition_Goal_Type.Maintain_Weight);
        Assert.assertEquals(ng[1].getGoal_Type(), Nutrition_Goal.Nutrition_Goal_Type.Weight_Loss);
        Assert.assertEquals(ng[2].getGoal_Type(), Nutrition_Goal.Nutrition_Goal_Type.Gain_Weight);
    }

    @Test
    public void CheckActivation() {
        Assert.assertTrue(ng.isActive());
        Assert.assertNotNull(ng.getStartDate());
        Assert.assertNull(ng.getEndDate());
        ng.diactivateGoal();
        Assert.assertFalse(ng.isActive());
        Assert.assertNotNull(ng.getEndDate());
    }

    @Test
    public void CheckdiActivate() {
        Nutrition_Goal ng=new Nutrition_Goal("Maintain_Weight",10);
    }

}