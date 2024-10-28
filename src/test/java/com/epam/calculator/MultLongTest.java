package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultLongTest extends BaseTest {

    @Test(dataProvider = "positiveMultLongData", groups = {"positive"})
    public void testPositiveMultLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.mult(a, b), expected,
                "There is an error in multiplication: " + a + " * " + b);
    }

    @Test(dataProvider = "negativeMultLongData", groups = {"negative"})
    public void testNegativeMultLong(long a, long b) {
        Assert.assertThrows(IllegalArgumentException.class, () -> calculator.mult(a, b));
    }

    @DataProvider(name = "positiveMultLongData")
    public Object[][] createPositiveMultLongData() {
        return new Object[][]{
                {24, 37, 888},
                {-31, 4, -124},
                {-19, -47, 893},
                {0, 2, 0}
        };
    }

    @DataProvider(name = "negativeMultLongData")
    public Object[][] createNegativeMultLongData() {
        return new Object[][]{
                {Long.MAX_VALUE, 2},
                {Long.MIN_VALUE, 2}
        };
    }
}
