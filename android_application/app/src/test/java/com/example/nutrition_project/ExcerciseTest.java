package com.example.nutrition_project;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcerciseTest {
Excercise e;
@Before
public void startExcercise(){
    e=new Excercise("Run",50,35,16.2,22.6,100,5,"Light");
}
@Test
    public void checkSporType(){
    Excercise []ex=new Excercise[3];
    String []types={"Light","Normal","Intense"};
    for(int i=0; i<3; i++)ex[i]=new Excercise("Run",50,35,16.2,22.6,100,5,types[i]);
    Assert.assertEquals(ex[0].getType(), Excercise.TypeSport.Light);
    Assert.assertEquals(ex[1].getType(), Excercise.TypeSport.Normal);
    Assert.assertEquals(ex[2].getType(), Excercise.TypeSport.Intense);

}
@Test
    public void checkHashIsNotNull(){
    Assert.assertNotNull(e.getExcercisePerformances());
}
@Test
public void checksizeofExcercisePerformance()throws Exception{
    e.addExcercisePerformance(new ExcercisePerformance(39.5,"morning"));
    e.addExcercisePerformance(new ExcercisePerformance(90,"afternoom"));
    Assert.assertTrue(e.getExcercisePerformances().size()==2);
}

}