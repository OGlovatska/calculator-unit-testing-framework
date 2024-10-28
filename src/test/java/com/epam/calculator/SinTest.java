package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "sinData", groups = {"positive"})
    public void testSin(double a, double expected) {
        Assert.assertEquals(calculator.sin(Math.toRadians(a)), expected, DELTA,
                "There is an error in calculating sinus for an angle " + a);
    }

    @DataProvider(name = "sinData")
    public Object[][] createSinData() {
        return new Object[][]{
                {0, 0.0},
                {30, 0.5},
                {45, Math.sqrt(2) / 2},
                {60, Math.sqrt(3) / 2},
                {90, 1.0},
                {120, Math.sqrt(3) / 2},
                {180, 0.0},
                {270, -1.0},
                {360, 0.0},
                {-94, -0.9975640502598242},
                {17.44, 0.29970690475106376},
                {Double.NEGATIVE_INFINITY, Double.NaN},
                {Double.POSITIVE_INFINITY, Double.NaN},
        };
    }
}
