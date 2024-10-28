package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "cosData", groups = {"positive"})
    public void testCos(double a, double expected) {
        Assert.assertEquals(calculator.cos(Math.toRadians(a)), expected, DELTA,
                "There is an error in calculating cosine for an angle " + a);
    }

    @DataProvider(name = "cosData")
    public Object[][] createCosData() {
        return new Object[][]{
                {0, 1.0},
                {30, Math.sqrt(3) / 2},
                {45, Math.sqrt(2) / 2},
                {60, 0.5},
                {90, 0.0},
                {120, -0.5},
                {180, -1.0},
                {270, 0.0},
                {360, 1.0},
                {-50, 0.6427876096865394},
                {60.13, 0.4980337653666372},
                {Double.NEGATIVE_INFINITY, Double.NaN},
                {Double.POSITIVE_INFINITY, Double.NaN}
        };
    }
}
