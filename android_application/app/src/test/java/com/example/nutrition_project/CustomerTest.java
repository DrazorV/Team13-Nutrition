package com.example.nutrition_project;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CustomerTest{
Customer cu;
    @Before
    public void checkCust()throws Exception{
        cu=new Customer("MMorf","Abcde3/","Manos","Morfiadakis","male",17,1.78,70.8,"Weight_Loss","Intense",60);
        Assert.assertNotNull(cu.getExcercisePerformances());
        Assert.assertNotNull(cu.getFoodConsumptions());
        Assert.assertNotNull(cu.getWeightStatuses());
        Assert.assertEquals(cu.getGoals(), Nutrition_Goal.Nutrition_Goal_Type.Weight_Loss);
    }
    @Test
            (expected=PasswordException.class)
    public void wrongPasword()throws Exception{
        cu.setPassword("WSW");
    }
    @Test
            (expected=PasswordException.class)
    public void wrongPassword2()throws Exception{
        cu.setPassword("WWWWW");
    }
    @Test
            (expected=PasswordException.class)
    public void wrongPassword3()throws Exception{
        cu.setPassword("WWWWW9");
    }
    @Test
            (expected=PasswordException.class)
    public void wrongPassword4()throws Exception{
        cu.setPassword("WWWWW/");
    }
    @Test(expected=NameException.class)
    public void wrongNameOrSurname()throws Exception{
        cu.check("Masn0");
    }
    @Test(expected=AgeException.class)
    public void invalidAge()throws Exception{
        cu.checkAge(9);
    }
    @Test(expected=AgeException.class)
    public void invalidAge2()throws Exception{
        cu.checkAge(100);
    }
    @Test(expected=HeightException.class)
    public void invalidHeight()throws Exception{
        cu.checkHeight(-0.1);
    }
    @Test(expected=HeightException.class)
    public void invalidHeight2()throws Exception{
        cu.checkHeight(7.01);
    }
    @Test(expected=WeightException.class)
    public void NegativeWeight()throws Exception{
        cu.checkWeight(-0.1);
    }
    @Test(expected = BMIException.class)
    public void checkBMI()throws Exception{
        cu.BMR(40*cu.getHeight()*cu.getHeight()+0.001);
    }
    @Test
    public void checkBMR()throws Exception{
        Assert.assertTrue(cu.BMR(70)==1896);
        cu.setAge(18);
        Assert.assertTrue(cu.BMR(70)==1749);
        cu.setAge(30);
        Assert.assertTrue(cu.BMR(70)==1678);
        cu.setAge(60);
        Assert.assertTrue(cu.BMR(70)==1533);
        cu.setAge(75);
        Assert.assertTrue(cu.BMR(70)==1409);
        cu.changeGender();
        cu.setAge(17);
        Assert.assertTrue(cu.BMR(70)==1630);
        cu.setAge(18);
        Assert.assertTrue(cu.BMR(70)==1523);
        cu.setAge(30);
        Assert.assertTrue(cu.BMR(70)==1268);
        cu.setAge(60);
        Assert.assertTrue(cu.BMR(70)==1331);
        cu.setAge(75);
        Assert.assertTrue(cu.BMR(70)==1310);
        cu.changeGender();
        cu.setAge(17);
        Assert.assertTrue(cu.BMR(35)==1776.5);
        cu.setAge(18);
        Assert.assertTrue(cu.BMR(35)==1720.5);
        cu.setAge(30);
        Assert.assertTrue(cu.BMR(35)==1775.5);
        cu.setAge(60);
        Assert.assertTrue(cu.BMR(35)==1616.5);
        cu.setAge(75);
        Assert.assertTrue(cu.BMR(35)==1615);
        cu.changeGender();
        cu.setAge(17);
        Assert.assertTrue(cu.BMR(35)==1661);
        cu.setAge(18);
        Assert.assertTrue(cu.BMR(35)==1505);
        cu.setAge(30);
        Assert.assertTrue(cu.BMR(35)==1477.5);
        cu.setAge(60);
        Assert.assertTrue(cu.BMR(35)==1509);
        cu.setAge(75);
        Assert.assertTrue(cu.BMR(35)==1467);
        cu.changeGender();
        cu.setAge(17);
        Assert.assertTrue(cu.BMR(86)==17.7*86+657-500);
        cu.setAge(18);
        Assert.assertTrue(cu.BMR(86)==1490.6);
        cu.setAge(30);
        Assert.assertTrue(cu.BMR(86)==1362);
        cu.setAge(60);
        Assert.assertTrue(cu.BMR(86)==1223.4);
        cu.setAge(75);
        Assert.assertTrue(cu.BMR(86)==1043.4);
        cu.changeGender();
        cu.setAge(17);
        Assert.assertTrue(cu.BMR(86)==1344.4);
        cu.setAge(18);
        Assert.assertTrue(cu.BMR(86)==1259.8);
        cu.setAge(30);
        Assert.assertTrue(cu.BMR(86)==8.3*86+687-500);
        cu.setAge(60);
        Assert.assertTrue(cu.BMR(86)==9.2*86+687-500);
        cu.setAge(75);
       Assert.assertTrue(cu.BMR(86)==9.8*86+624-500);
        cu.changeGender();
        cu.setAge(50);
        Assert.assertTrue(cu.BMR(100)==5+10*100+6.25*1.78-5*50);
        cu.changeGender();
        Assert.assertTrue(cu.BMR(100)==10*100+6.25*1.78-5*50-161);
        cu.changeGender();
    }
    @Test
    public void checkPAL()throws Exception{//if this  method runs with other test it is false.But if it runs indipendently it is true.
        cu.setJobType("Light");
        Excercise e=new Excercise("run",50,40,10,13.7,100.8,5,"Light");
        ExcercisePerformance ep=new ExcercisePerformance(20,"Morning",e);
        cu.addExcercisePerformance(ep);
        Assert.assertTrue(cu.PAL()==1.4);
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.4);
        cu.changeGender();
        cu.setJobType("Normal");
        Assert.assertTrue(cu.PAL()==1.6);
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.5);
        cu.changeGender();
        cu.setJobType("Intense");
        Assert.assertTrue(cu.PAL()==1.7);
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.5);
        cu.changeGender();
        cu.setJobType("Light");
        Excercise e2=new Excercise("run",50,40,10,13.7,100.8,5,"Normal");
        ExcercisePerformance ep2=new ExcercisePerformance(20,"Morning",e2);
        cu.addExcercisePerformance(ep2);
        Assert.assertTrue(cu.PAL()==1.5);
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.5);
        cu.changeGender();
        cu.setJobType("Normal");
        Assert.assertTrue(cu.PAL()==1.7);
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.6);
        cu.changeGender();
        cu.setJobType("Intense");
        Assert.assertTrue(cu.PAL()==1.8);
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.6);
        cu.changeGender();
        cu.setJobType("Light");
        Excercise e3=new Excercise("AK-47",50,40,10,13.7,100.8,5,"Intense");
        ExcercisePerformance ep3=new ExcercisePerformance(20,"Morning",e3);
        cu.addExcercisePerformance(ep3);
        Assert.assertEquals(e3.getType(), Excercise.TypeSport.Intense);
        Assert.assertTrue(cu.PAL()==1.6);
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.6);
        cu.setJobType("Normal");
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.8);
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.7);
        cu.setJobType("Intense");
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.9);
        cu.changeGender();
        Assert.assertTrue(cu.PAL()==1.7);

    }
}