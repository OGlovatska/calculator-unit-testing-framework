package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveTest extends BaseTest {

    @Test(dataProvider = "isPositiveData", groups = {"positive"})
    public void testIsPositive(long a,boolean expected) {
        Assert.assertEquals(calculator.isPositive(a), expected);
    }

    @DataProvider(name = "isPositiveData")
    public Object[][] createIsPositiveData() {
        return new Object[][]{
                {1, true},
                {100, true},
                {Long.MAX_VALUE, true},
                {0, false},
                {-1, false},
                {-100, false},
                {Long.MIN_VALUE, false}
        };
    }
}
