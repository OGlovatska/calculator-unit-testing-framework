package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivDoubleTest extends BaseTest {

    private static final double DELTA = 1e-10;

    @Test(dataProvider = "positiveDivDoubleData", groups = {"positive"})
    public void testPositiveDivDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected, DELTA,
                "There is an error in division: " + a + " / " + b);
    }

    @Test(dataProvider = "negativeDivDoubleData", groups = {"negative"})
    public void testNegativeDivDouble(double a, double b) {
        Assert.assertThrows(NumberFormatException.class, () -> calculator.div(a, b));
    }

    @DataProvider(name = "positiveDivDoubleData")
    public Object[][] createPositiveDivDoubleData() {
        return new Object[][]{
                {9.24, 3.2, 2.8875},
                {6.0, 3.0, 2.0},
                {-14.0, 9.13, -1.53340635268346},
                {-65.85, -74.91, 0.879054865839007},
                {0, 7.6411, 0},
                {Double.MAX_VALUE, 1.0, Double.MAX_VALUE},
                {1.0, Double.MAX_VALUE, 1.0 / Double.MAX_VALUE},
                {Double.MIN_VALUE, 1.0, Double.MIN_VALUE}
        };
    }

    @DataProvider(name = "negativeDivDoubleData")
    public Object[][] createNegativeDivDoubleData() {
        return new Object[][]{
                {9.24, 0},
                {-6.0, 0},
                {Double.MAX_VALUE, 0},
                {-Double.MIN_VALUE, 0},
                {0, 0}
        };
    }
}
