package com.example.team13_nutrition;

import org.junit.Assert;
import org.junit.Test;

public class ExercisePerformanceTest {

    @Test
    public void CheckDateIsNotNULL()throws Exception {
      ExcercisePerformance ep=new ExcercisePerformance(5,"morning",new Exercise("Run",50,35,16.2,22.6,"Intense"));
        Assert.assertNotNull(ep.getDate());
    }
}