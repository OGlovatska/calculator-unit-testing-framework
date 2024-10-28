package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivLongTest extends BaseTest {

    @Test(dataProvider = "positiveDivLongData", groups = {"positive"})
    public void testPositiveDivLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.div(a, b), expected,
                "There is an error in division: " + a + " / " + b);
    }

    @Test(dataProvider = "negativeDivLongData", groups = {"negative"})
    public void testNegativeDivLong(long a, long b) {
        Assert.assertThrows(NumberFormatException.class, () -> calculator.div(a, b));
    }

    @DataProvider(name = "positiveDivLongData")
    public Object[][] createPositiveDivLongData() {
        return new Object[][]{
                {7, 2, 3L},
                {-14, 7, -2L},
                {-5, 8, -1L},
                {0, 4, 0L},
        };
    }

    @DataProvider(name = "negativeDivLongData")
    public Object[][] createNegativeDivLongData() {
        return new Object[][]{
                {7, 0},
                {Long.MAX_VALUE, 0},
                {Long.MIN_VALUE, 0},
                {0, 0}
        };
    }
}
