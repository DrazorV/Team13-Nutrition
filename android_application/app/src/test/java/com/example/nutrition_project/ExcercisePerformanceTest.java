package com.example.nutrition_project;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcercisePerformanceTest {

    @Test
    public void CheckDateIsNotNULL()throws Exception {
      ExcercisePerformance ep=new ExcercisePerformance(5,"morning",new Excercise("Run",50,35,16.2,22.6,100,5,"Intense"));
        Assert.assertNotNull(ep.getDate());
    }
}