package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TgTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "tgData", groups = {"positive"})
    public void testTg(double a, double expected) {
        Assert.assertEquals(calculator.tg(Math.toRadians(a)), expected, DELTA,
                "There is an error in calculating tangent for an angle " + a);
    }

    @DataProvider(name = "tgData")
    public Object[][] createTgData() {
        return new Object[][]{
                {0, 0.0},
                {30, 1.0 / Math.sqrt(3.0)},
                {45, 1.0},
                {60, Math.sqrt(3.0)},
                {90, Double.POSITIVE_INFINITY},
                {120, - Math.sqrt(3.0)},
                {180, 0.0},
                {270, Double.POSITIVE_INFINITY},
                {360, 0.0},
                {-74, -3.4874144438409087},
                {15.95, 0.2858012041276529},
                {Double.NEGATIVE_INFINITY, Double.NaN},
                {Double.POSITIVE_INFINITY, Double.NaN}
        };
    }
}
