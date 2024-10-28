package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubLongTest extends BaseTest {

    @Test(dataProvider = "positiveSubLongData", groups = {"positive"})
    public void testPositiveSubLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.sub(a, b), expected,
                "There is an error in subtraction: " + a + " - " + b);
    }

    @Test(dataProvider = "negativeSubLongData", groups = {"negative"})
    public void testNegativeSubLong(long a, long b) {
        Assert.assertThrows(IllegalArgumentException.class, () -> calculator.sub(a, b));
    }

    @DataProvider(name = "positiveSubLongData")
    public Object[][] createPositiveSubLongData() {
        return new Object[][]{
                {8, 17, -9},
                {-3, 5, -8},
                {-11, -7, -4},
                {0, 0, 0},
                {Long.MAX_VALUE, Long.MAX_VALUE, 0},
                {Long.MIN_VALUE, Long.MIN_VALUE, 0}
        };
    }

    @DataProvider(name = "negativeSubLongData")
    public Object[][] createNegativeSubLongData() {
        return new Object[][]{
                {Long.MAX_VALUE, -1},
                {Long.MIN_VALUE, 1}
        };
    }
}
