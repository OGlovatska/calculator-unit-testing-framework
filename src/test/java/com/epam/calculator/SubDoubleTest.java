package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubDoubleTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "subDoubleData", groups = {"positive"})
    public void testPositiveSub(double a, double b, double expected) {
        Assert.assertEquals(calculator.sub(a, b), expected, DELTA,
                "There is an error in subtraction: " + a + " - " + b);
    }

    @DataProvider(name = "subDoubleData")
    public Object[][] createSubDoubleData() {
        return new Object[][]{
                {7.5, 14.1, -6.6},
                {-6.33, 4.12, -10.45},
                {-14.96, -11.23, -3.73},
                {0, 0, 0},
                {Double.MAX_VALUE, Double.MIN_VALUE, 1.7976931348623157E308},
                {Double.MIN_VALUE, 0, Double.MIN_VALUE},
                {0, Double.MAX_VALUE, -Double.MAX_VALUE}
        };
    }
}
