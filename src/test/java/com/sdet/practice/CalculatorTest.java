package com.sdet.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calc;

    @BeforeMethod
    public void setUp(){

        calc = new Calculator();
    }

    @Test
    public void testAddFeature(){

        Assert.assertEquals(calc.add(3,5),8);

    }

    @Test
    public void testSubtractFeature(){

        Assert.assertEquals(calc.subtract(8,6),2);
    }

    @Test
    public void testMultiplyFeature(){

        Assert.assertEquals(calc.multiply(5,5),25);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero(){

        calc.divide(100,0);
    }

}
