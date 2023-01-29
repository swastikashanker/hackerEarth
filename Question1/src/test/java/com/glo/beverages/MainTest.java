package com.glo.beverages;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void beverageTest() throws ClassNotFoundException {
        assertTrue(Beverage.class.isInterface());
        assertTrue(Modifier.isAbstract(BeverageDecorator.class.getModifiers()));
        Beverage coffee = new Coffee(50);
        Beverage tea = new Tea(25);
        assertEquals(50, coffee.getCost());
        assertEquals(25, tea.getCost());
        assertTrue("coffee".equalsIgnoreCase(coffee.getDescription()));
        assertTrue("tea".equalsIgnoreCase(tea.getDescription()));
    }

    @Test
    public void beverageDecoratorTest() {
        Beverage coffee = new Coffee(25);
        BeverageDecorator caramelCoffee = new Caramel(50, coffee);
        assertEquals(75, caramelCoffee.getCost());
        assertTrue("coffee topped with caramel".equalsIgnoreCase(caramelCoffee.getDescription()));
    }

    public BeverageDecorator getInstance(String className, Beverage beverage, int cost) throws ClassNotFoundException {
        Class classForClassName = Class.forName(className);
        Class[][] parameterTypes = {{Beverage.class, int.class}, {Beverage.class, Integer.class}, {int.class, Beverage.class}, {Integer.class, Beverage.class}};
        Object[][] paramValues = {{beverage, cost}, {beverage, new Integer(cost)}, {cost, beverage}, {new Integer(cost), beverage}};
        for (int i = 0; i < 4; i++) {
            try {
                BeverageDecorator beverageDecorator = (BeverageDecorator) classForClassName.asSubclass(BeverageDecorator.class).getConstructor(parameterTypes[i]).newInstance(paramValues[i]);
                return beverageDecorator;
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
                continue;
            }
        }
        fail();
        return null;
    }

    @Test
    public void test() {
        assertTrue(Beverage.class.isInterface());
        Method[] declaredMethods = Beverage.class.getDeclaredMethods();
        assertTrue(declaredMethods.length == 2);
//		System.out.println(declaredMethods[0].toString());
        assertTrue(declaredMethods[0].toString().equals("public abstract java.lang.String com.glo.beverages.Beverage.getDescription()"));
        assertTrue(declaredMethods[1].toString().equals("public abstract int com.glo.beverages.Beverage.getCost()"));
        assertTrue(Modifier.isAbstract(BeverageDecorator.class.getModifiers()));
        Beverage coffee = new Coffee(50);
        Beverage tea = new Tea(25);
        assertEquals(50, coffee.getCost());
        assertEquals(25, tea.getCost());
        assertTrue("coffee".equalsIgnoreCase(coffee.getDescription()));
        assertTrue("tea".equalsIgnoreCase(tea.getDescription()));
        BeverageDecorator coffeeWithCream = null;
        try {
            coffeeWithCream = getInstance("com.glo.beverages.Cream", coffee, 25);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            fail();
        }
        assertEquals(75, coffeeWithCream.getCost());
        assertTrue("coffee topped with cream".equalsIgnoreCase(coffeeWithCream.getDescription()));

        BeverageDecorator coffeeWithCreamAndChocolate = null;
        try {
            coffeeWithCreamAndChocolate = getInstance("com.glo.beverages.Chocolate", coffeeWithCream, 15);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            fail();
        }
        assertEquals(90, coffeeWithCreamAndChocolate.getCost());
        assertTrue("coffee topped with cream topped with chocolate".equalsIgnoreCase(coffeeWithCreamAndChocolate.getDescription()));
        BeverageDecorator teaWithHoney = null;
        try {
            teaWithHoney = getInstance("com.glo.beverages.Honey", tea, 30);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            fail();
        }
        assertEquals(55, teaWithHoney.getCost());
        assertTrue("tea topped with honey".equalsIgnoreCase(teaWithHoney.getDescription()));
        BeverageDecorator teaWithHoneyAndChocolate = null;
        try {
            teaWithHoneyAndChocolate = getInstance("com.glo.beverages.Chocolate", teaWithHoney, 17);
        } catch (ClassNotFoundException e) {
            fail();
        }
        assertEquals(72, teaWithHoneyAndChocolate.getCost());
        assertTrue("tea topped with honey topped with chocolate".equalsIgnoreCase(teaWithHoneyAndChocolate.getDescription()));

    }


}