package com.example.tean13_nutrition;
import com.example.tean13_nutrition.Excercise;
import com.example.tean13_nutrition.ExcercisePerformance;

import org.junit.Assert;
import org.junit.Test;

public class ExcercisePerformanceTest {

    @Test
    public void CheckDateIsNotNULL()throws Exception {
      ExcercisePerformance ep=new ExcercisePerformance(5,"morning",new Excercise("Run",50,35,16.2,22.6,100,5,"Intense"));
        Assert.assertNotNull(ep.getDate());
    }
}