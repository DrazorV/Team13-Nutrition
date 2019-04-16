import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodConsumptionTest {
    public FoodConsumption fc;
     @Test
     public void checkDateIsNotNull(){
         fc=new FoodConsumption(5,"Breakfast");
         Assert.assertNotNull(fc.getDate());
     }
     @Test
    public void check(){
         FoodConsumption fc[]=new FoodConsumption[3];
         fc[0]=new FoodConsumption(5,"Breakfast");
         fc[1]=new FoodConsumption(10,"Lunch");
         fc[2]=new FoodConsumption(15,"Dinner");
         Assert.assertEquals(fc[0].getMealType(), FoodConsumption.MealType.Breakfast);
         Assert.assertEquals(fc[1].getMealType(), FoodConsumption.MealType.Lunch);
         Assert.assertEquals(fc[2].getMealType(), FoodConsumption.MealType.Dinner);
     }
}