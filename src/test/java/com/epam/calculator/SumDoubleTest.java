package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumDoubleTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "positiveSumDoubleData", groups = {"positive"})
    public void testPositiveSumDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, DELTA,
                "There is an error in addition: " + a + " + " + b);
    }

    @Test(dataProvider = "negativeSumDoubleData", groups = {"negative"})
    public void testNegativeSumDouble(double a, double b) {
        Assert.assertThrows(IllegalArgumentException.class, () -> calculator.sum(a, b));
    }

    @DataProvider(name = "positiveSumDoubleData")
    public Object[][] createPositiveSumDoubleData() {
        return new Object[][]{
                {14.1, 5.3, 19.4},
                {8.111111, 7.9, 16.011111},
                {-3.85, -5.74, -9.59},
                {-22.15, 22.15, 0},
                {0.0, 0.0, 0.0},
                {Double.MAX_VALUE, 0.0, Double.MAX_VALUE},
                {-Double.MAX_VALUE, 0.0, -Double.MAX_VALUE}
        };
    }

    @DataProvider(name = "negativeSumDoubleData")
    public Object[][] createNegativeSumDoubleData() {
        return new Object[][]{
                {Double.MAX_VALUE, 1},
                {-Double.MAX_VALUE, -1}
        };
    }
}
