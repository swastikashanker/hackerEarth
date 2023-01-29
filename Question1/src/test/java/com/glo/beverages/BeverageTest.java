package com.glo.beverages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeverageTest {

    @Before
    public void setUp() {
        System.out.println("Before Testing");

    }

    @After
    public void tearDown() {
        System.out.println("Testing completed");
    }

    @Test
    public void testBeverage() {
        Beverage tea = new Tea(35);
        BeverageDecorator honey = new Honey( 25,tea);

        assertEquals(60, honey.getCost());
        assertTrue("tea topped with honey".equalsIgnoreCase(honey.getDescription()));
    }
}