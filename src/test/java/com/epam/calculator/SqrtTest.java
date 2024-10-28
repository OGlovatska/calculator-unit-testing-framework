package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "sqrtData", groups = {"positive"})
    public void testSqrt(double a, double expected) {
        Assert.assertEquals(calculator.sqrt(a), expected, DELTA,
                "There is an error in calculating square root of number: " + a);
    }

    @DataProvider(name = "sqrtData")
    public Object[][] createSqrtData() {
        return new Object[][]{
                {5.0, 2.23606797749979},
                {16, 4.0},
                {39.84, 6.3118935352238},
                {0.0, 0.0},
                {-7.0, Double.NaN},
                {-14.36, Double.NaN},
                {Double.MAX_VALUE, 1.3407807929942596E154},
                {Double.MIN_VALUE, 2.2227587494850775E-162},
                {-Double.MAX_VALUE, Double.NaN},
                {-Double.MIN_VALUE, Double.NaN},
                {Double.NaN, Double.NaN}
        };
    }
}
