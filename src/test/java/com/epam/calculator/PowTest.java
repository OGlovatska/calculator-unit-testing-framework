package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "powData", groups = {"positive"})
    public void testPow(double a, double b, double expected) {
        Assert.assertEquals(calculator.pow(a, b), expected, DELTA,
                "There is an error in rising a number " + a + " to a power " + b);
    }

    @DataProvider(name = "powData")
    public Object[][] createPowData() {
        return new Object[][]{
                {5.0, 2.0, 25.0},
                {2.0, -3.0, 0.125},
                {-7.0, 8.0, 5764801.0},
                {-4.0, -3.0, -0.015625},
                {5.47, 9.0, 4384155.373006582},
                {1.7, 0.6, 1.3748944308911808},
                {2.0, -1.3, 0.40612619817811774},
                {-8.15, 4.0, 4411.948506250001},
                {3.6, 0, 1.0},
                {-7.0, 0, 1.0},
                {0.0, 0.0, 1.0},
                {-4.47, -1.9, Double.NaN},
                {0.0, -5.0, Double.POSITIVE_INFINITY},
                {Double.MAX_VALUE, 2.0, Double.POSITIVE_INFINITY},
                {Double.MIN_VALUE, -3.36, Double.POSITIVE_INFINITY}
        };
    }
}
