package com.example.team13_nutrition;

import org.junit.Assert;
import org.junit.Test;

public class ExercisePerformanceTest {

    @Test
    public void CheckDateIsNotNULL()throws Exception {
        ExercisePerformance ep = new ExercisePerformance(5, new Exercise("Run", 50,  "Intense"));
        Assert.assertNotNull(ep.getDate());
    }
}