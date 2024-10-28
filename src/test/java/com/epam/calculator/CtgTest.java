package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CtgTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "ctgData", groups = {"positive"})
    public void testCtg(double a, double expected) {
        Assert.assertEquals(calculator.ctg(Math.toRadians(a)), expected, DELTA,
                "There is an error in calculating cotangent for an angle " + a);
    }

    @DataProvider(name = "ctgData")
    public Object[][] createCtgData() {
        return new Object[][]{
                {0, Double.POSITIVE_INFINITY},
                {30, Math.sqrt(3)},
                {45, 1.0},
                {60, 1.0 / Math.sqrt(3)},
                {90, 0.0},
                {120, - 1 / Math.sqrt(3)},
                {180, Double.POSITIVE_INFINITY},
                {270, 0.0},
                {360, Double.POSITIVE_INFINITY},
                {-14, -4.010780933535845},
                {84.11, 0.10316355377977726},
                {Double.NEGATIVE_INFINITY, Double.NaN},
                {Double.POSITIVE_INFINITY, Double.NaN}
        };
    }
}
