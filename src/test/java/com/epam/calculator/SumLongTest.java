package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumLongTest extends BaseTest {

    @Test(dataProvider = "positiveSumLongData", groups = {"positive"})
    public void testPositiveSumLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.sum(a, b), expected,
                "There is an error in addition: " + a + " + " + b);
    }

    @Test(dataProvider = "negativeSumLongData", groups = {"negative"})
    public void testNegativeSumLong(long a, long b) {
        Assert.assertThrows(IllegalArgumentException.class, () -> calculator.sum(a, b));
    }

    @DataProvider(name = "positiveSumLongData")
    public Object[][] createPositiveSumLongData() {
        return new Object[][]{
                {2, 3, 5},
                {-1, 1, 0},
                {0, 0, 0},
                {Long.MAX_VALUE - 1, 1, Long.MAX_VALUE},
                {Long.MIN_VALUE + 1, -1, Long.MIN_VALUE}
        };
    }

    @DataProvider(name = "negativeSumLongData")
    public Object[][] createNegativeSumLongData() {
        return new Object[][]{
                {Long.MAX_VALUE, 1},
                {Long.MIN_VALUE, -1}
        };
    }
}
