package com.example.tean13_nutrition;
import com.example.tean13_nutrition.WeightStatus;

import org.junit.Assert;
import org.junit.Test;

public class WeightStatusTest {
    @Test
    public  void DateIsNotNull(){
        WeightStatus ws=new WeightStatus(60.5,6,7);
        Assert.assertNotNull(ws.getDate());
    }

}