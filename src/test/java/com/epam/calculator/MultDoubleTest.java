package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultDoubleTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "positiveMultDoubleData", groups = {"positive"})
    public void testPositiveMultDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.mult(a, b), expected, DELTA,
                "There is an error in multiplication: " + a + " * " + b);
    }

    @Test(dataProvider = "negativeMultDoubleData", groups = {"negative"})
    public void testNegativeMultDouble(double a, double b) {
        Assert.assertThrows(IllegalArgumentException.class, () -> calculator.mult(a, b));
    }

    @DataProvider(name = "positiveMultDoubleData")
    public Object[][] createPositiveMultDoubleData() {
        return new Object[][]{
                {12.0, 5.0, 60.0},
                {45.21, 36.78, 1662.8238},
                {-85.32, 9.13, -778.9716},
                {-65.85, -74.91, 4932.8235},
                {0, 7.6411, 0},
                {0, 0, 0},
                {1.0, 1.0, 1.0}
        };
    }

    @DataProvider(name = "negativeMultDoubleData")
    public Object[][] createNegativeMultDoubleData() {
        return new Object[][]{
                {Double.MAX_VALUE, 2},
                {-Double.MAX_VALUE, 2},
                {12.0, Double.NaN},
        };
    }
}
