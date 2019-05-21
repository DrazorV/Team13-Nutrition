package com.example.team13_nutrition;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExerciseTest {
Exercise e;
@Before
public void startExcercise(){
    e=new Exercise("Run",50,"Light");
}
@Test
    public void checkSporType(){
    Exercise[]ex=new Exercise[3];
    String []types={"Light","Normal","Intense"};
    for(int i=0; i<3; i++)ex[i]=new Exercise("Run",50,types[i]);
    Assert.assertEquals(ex[0].getType(), Exercise.TypeSport.Light);
    Assert.assertEquals(ex[1].getType(), Exercise.TypeSport.Normal);
    Assert.assertEquals(ex[2].getType(), Exercise.TypeSport.Intense);

}



}