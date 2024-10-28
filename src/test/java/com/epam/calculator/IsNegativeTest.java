package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsNegativeTest extends BaseTest {

    @Test(dataProvider = "isNegativeData", groups = {"positive"})
    public void testIsNegative(long a,boolean expected) {
        Assert.assertEquals(calculator.isNegative(a), expected);
    }

    @DataProvider(name = "isNegativeData")
    public Object[][] createIsNegativeData() {
        return new Object[][]{
                {-1, true},
                {-100, true},
                {Long.MIN_VALUE, true},
                {0, false},
                {1, false},
                {100, false},
                {Long.MAX_VALUE, false}
        };
    }
}
