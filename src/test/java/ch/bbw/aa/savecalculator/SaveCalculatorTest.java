package ch.bbw.aa.savecalculator;

/*
 * Unit test for simple App.
 * * @author Al-Kubaisi Abdullah
 * * @version 25.12.2022
 */

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
    public void setUp() {
        testee = new SaveCalculator();
    }

    @After
    public void testAfter() {
        testee = null;
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

    // test methode summe with zero and one positive
    @Test
    public void testSummeEinZeroEinPositiveIsOk() {
        assertEquals(15, testee.summe(0, 15));

    }

    // test methode summe with zero and one negative
    @Test
    public void testSummeEinZeroEinNegativeIsOk() {
        assertEquals(-10, testee.summe(0, -10));

    }

    // test methode summe with MaxValue and one positive
    @Test(expected = ArithmeticException.class)
    public void testSummeGroesstePositiveUndKleinstePositiveIsNotOk() {
       testee.summe(Integer.MAX_VALUE, 1);
    }

    // test methode summe with MinValue with one positive
    @Test
    public void testSummeGroessteNegativeUndKleinstePositiveIsOk() {
        assertEquals(-2147483647, testee.summe(Integer.MIN_VALUE, 1));

    }
    // test methode summe with MaxValue and MinValue
    @Test
    public void testSummeEinMaxPositiveEinMinNegativeIsOk() {
        assertEquals(-1, testee.summe(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    // test methode summe with min negative value  and max negative Value
    @Test(expected = ArithmeticException.class)
    public void testSummeEinMinNegativeEinMaxNegativeIsOk() {
        assertEquals(-1, testee.summe(-1, Integer.MIN_VALUE));
    }

    // test methode subtraktion with two positive numbers
    @Test
    public void testSubZweiPositiveIsOk() {
        assertEquals(-10, testee.subtraktion(10, 20));

    }

    // test methode Subtraktion with two negative numbers
    @Test
    public void testSubZweiNegativeIsOk() {
        assertEquals(10, testee.subtraktion(-10, -20));

    }

    // test methode subtraktion with one negative and one positive numbers
    @Test
    public void testSubEinNegativeEinPositiveIsOk() {
        assertEquals(50, testee.subtraktion(10, -40));

    }

    // test methode subtraktion with zero and one positive
    @Test
    public void testSubEinZeroEinPositiveIsOk() {
        assertEquals(-40, testee.subtraktion(0, 40));

    }

    // test methode subtraktion with zero and one negative
    @Test
    public void testSubEinZeroEinNegativeIsOk() {
        assertEquals(40, testee.subtraktion(0, -40));

    }

    // test methode subtraktion with MaxValue and one negative number
    @Test(expected = ArithmeticException.class)
    public void testSubGroesstePositiveUndKleinsteNegativeIsNotOk() {
        testee.subtraktion(Integer.MAX_VALUE, -1);

    }

    // test methode subtraktion with MaxValue and one positive
    @Test
    public void testSubGroesstePositiveUndKleinstePositiveIsOk() {
        assertEquals( 2147483646, testee.subtraktion(Integer.MAX_VALUE, 1));
    }

    // test methode subtraktion with MinValue and one negative number
    @Test
    public void testSubGroessteNegativeUndKleinsteNegativeIsOk() {
        assertEquals( -2147483647, testee.subtraktion(Integer.MIN_VALUE, -1));

    }

    // test methode subtraktion with MinValue with one positive
    @Test(expected = ArithmeticException.class)
    public void testSubGroessteNegativeUndKleinstePositiveIsOk() {
        testee.subtraktion(Integer.MIN_VALUE, 1);

    }

    // test methode division with two positive numbers
    @Test
    public void testDivisionZweiPositiveIsOk() {
        int value1 = 100;
        int value2 = 10;
        assertTrue(testee.division(value1, value2) == 10);
    }

    // test methode division with two negative numbers
    @Test
    public void testDivisionZweiNegativeIsOk() {
        int value1 = -100;
        int value2 = -10;
        assertTrue(testee.division(value1, value2) == 10);
    }

    // test methode division with one negative one positive and
    @Test
    public void testDivisionEinNegativeEinPositiveIsOk() {
        int value1 = -100;
        int value2 = 10;
        assertTrue(testee.division(value1, value2) == -10);
    }

    // test methode division with one positive and one negative
    @Test
    public void testDivisionEinPositiveEinNegativeIsOk() {
        int value1 = 100;
        int value2 = -10;
        assertTrue(testee.division(value1, value2) == -10);
    }

    // test methode division with zero and one positive
    @Test
    public void testDivisionEinZeroEinPositiveIsOk() {
        int value1 = 0;
        int value2 = 10;
        assertTrue(testee.division(value1, value2) == 0);

    }

    // test methode division with zero and one negative
    @Test
    public void testDivisionEinZeroEinNegativeIsOk() {
        int value1 = 0;
        int value2 = -10;
        assertTrue(testee.division(value1, value2) == 0);

    }

    // test methode division with MaxValue and one positive
    @Test
    public void testDivisionGroesstePositiveUndKleinstePositiveIsOk() {
        int value1 = Integer.MAX_VALUE;
        int value2 = 1;
        assertTrue(testee.division(value1, value2) == 2147483647);
    }

    // test methode division with MinValue with one positive
    @Test
    public void testDivisionGroessteNegativeUndKleinstePositiveIsOk() {
        int value1 = Integer.MIN_VALUE;
        int value2 = 1;
        assertTrue(testee.division(value1, value2) == -2147483648);

    }

    // test methode division with negative value and zero Value
    @Test(expected = ArithmeticException.class)
    public void testDivisionEinNegativeEinZeroIsOk() {
        testee.division(-1, 0);
    }

    // test methode division with positive value and zero Value
    @Test(expected = ArithmeticException.class)
    public void testDivisionEinPositiveEinZeroIsOk() {
        testee.division(10, 0);
    }

    // test methode sqrt of positive integer
    @Test
    public void testSqrtOfPositiveNumber()
    {
        assertEquals(5, testee.sqrt(25));
    }

    // test methode sqrt of negative integer
    @Test(expected = ArithmeticException.class)
    public void testSqrtOfNegativeNumber()
    {
        testee.sqrt(-36);
    }

    // test methode modulo of
    @Test
    public void testModuloOfTwoNumbers()
    {
        assertEquals(1, testee.modulo(10, 3));
    }

    @Test
    public void testConvertDecToHex()
    {
        assertEquals("A", testee.decToHex(-10));
    }

    @Test
    public void testConvertDecToBinary()
    {
        assertEquals("1111", testee.decToBinary(15));
    }

    @Test
    public void testConvertDecToOctal()
    {
        assertEquals("12", testee.decToOctal(10));
    }

    // test expected overflow of two integer values
    @Test(expected = ArithmeticException.class)
    public void testExceptedException() {
        testee.summe(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    // test unexpected overflow of two integer values
    @Test
    public void testUnExceptedException() throws ArithmeticException {
        testee.summe(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test // test will failed here, because the first assertion is wrong
    public void testMultipleAssert() {
        assertEquals(12, testee.summe(5, 5));
        assertEquals(10, testee.summe(10, 5));
        assertEquals(4, testee.summe(2, 2));
    }


    // calculating power of number by calling a protected method (because of maven structure we can call protected method here)
    // same package as SaveCalculator
    @Test
    public void testProtectedPower() {
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


}
