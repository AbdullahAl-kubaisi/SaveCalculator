package ch.bbw.pr.savecalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class SaveCalculatorTest {
    private SaveCalculator testee;

    // create saveCalculator object before all test begin to insure that testee not null
    @Before
    public void setUp()
    {
        testee = new SaveCalculator();
    }
    // test methode summe with two positive numbers
    @Test
    public void testSummeZweiPositiveIsOk() {
        assertEquals(30, testee.summe(10, 20));

    }

    // test methode summe with two negative numbers
    @Test
    public void testSummeZweiNegativeIsOk() {
        assertEquals(-30, testee.summe(-10, -20));

    }

    // test methode summe with one positive and one negative
    @Test
    public void testSummeEinNegativeEinPositiveIsOk() {
        assertEquals(-30, testee.summe(10, -40));

    }

    // test methode subtraktion with two positive numbers
    @Test
    public void testSubZweiPositiveIsOk() {
        assertEquals(-10, testee.subtraktion(10, 20));

    }

    // test methode subtraktion with two negative numbers
    @Test
    public void testSubZweiNegativeIsOk() {
        assertEquals(10, testee.subtraktion(-10, -20));

    }
    // test methode subtraktion with one negative and one positive numbers
    @Test
    public void testSubEinNegativeEinPositiveIsOk() {
        assertEquals(50, testee.subtraktion(10, -40));

    }

    // test expected overflow of two integer values
    @Test(expected = ArithmeticException.class)
    public void testExceptedException()
    {
        testee.summe(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    // test unexpected overflow of two integer values
    @Test
    public void testUnExceptedException() throws ArithmeticException
    {
        testee.summe(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test // test will failed here, because the first assertion is wrong
    public void testMultipleAssert()
    {
        assertEquals(12, testee.summe(5,5));
        assertEquals(10, testee.summe(10,5));
        assertEquals(4, testee.summe(2,2));
    }


    // calculating power of number by calling a protected method (because of maven structure we can call protected method here)
    // same package as SaveCalculator
    @Test
    public void testProtectedPower()
    {
        assertEquals(32, testee.pow(2, 5));
    }

    // use reflection to call private method
    // test multiplication of two numbers
    @Test(expected = NoSuchMethodException.class)
    public void testPrivateMul() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = testee.getClass().getDeclaredMethod("multiplication", int.class, int.class);
        method.setAccessible(true);
        assertEquals(10, method.invoke(testee, 2, 5));
    }

    @After
    public void testAfter()
    {
        testee = null;
    }
}
