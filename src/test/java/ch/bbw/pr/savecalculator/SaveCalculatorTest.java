package ch.bbw.pr.savecalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaveCalculatorTest {
    private SaveCalculator testee;

    @Before
    public void setUp()
    {
        testee = new SaveCalculator();
    }
    @Test
    public void testSummeZweiPositiveIsOk() {
        assertEquals(30, testee.summe(10, 20));
        assertEquals(50, testee.summe(25, 25));
        assertEquals(100, testee.summe(76, 24));
        assertEquals(97, testee.summe(20, 77));
        assertEquals(2899, testee.summe(1000, 1899));
        assertEquals(70, testee.summe(50, 20));
    }

    @Test
    public void testSummeZweiNegativeIsOk() {
        assertEquals(-30, testee.summe(-10, -20));
        assertEquals(-50, testee.summe(-25, -25));
        assertEquals(-100, testee.summe(-76, -24));
        assertEquals(-97, testee.summe(-20, -77));
        assertEquals(-2899, testee.summe(-1000, -1899));
        assertEquals(-70, testee.summe(-50, -20));
    }
    @Test
    public void testSummeEinNegativeEinPositiveIsOk() {
        assertEquals(-30, testee.summe(10, -40));
        assertEquals(0, testee.summe(+25, -25));
        assertEquals(-52, testee.summe(-76, 24));
        assertEquals(57, testee.summe(-20, 77));
        assertEquals(899, testee.summe(-1000, 1899));
        assertEquals(-30, testee.summe(-50, 20));
    }

    @Test
    public void testSubZweiPositiveIsOk() {
        assertEquals(-10, testee.subtraktion(10, 20));
        assertEquals(0, testee.subtraktion(25, 25));
        assertEquals(56, testee.subtraktion(76, 20));
        assertEquals(-57, testee.subtraktion(20, 77));
        assertEquals(-899, testee.subtraktion(1000, 1899));
        assertEquals(30, testee.subtraktion(50, 20));
    }

    @Test
    public void testSubZweiNegativeIsOk() {
        assertEquals(10, testee.subtraktion(-10, -20));
        assertEquals(0, testee.subtraktion(-25, -25));
        assertEquals(-52, testee.subtraktion(-76, -24));
        assertEquals(57, testee.subtraktion(-20, -77));
        assertEquals(899, testee.subtraktion(-1000, -1899));
        assertEquals(-30, testee.subtraktion(-50, -20));
    }
    @Test
    public void testSubEinNegativeEinPositiveIsOk() {
        assertEquals(50, testee.subtraktion(10, -40));
        assertEquals(50, testee.subtraktion(25, -25));
        assertEquals(-100, testee.subtraktion(-76, 24));
        assertEquals(-97, testee.subtraktion(-20, 77));
        assertEquals(-2899, testee.subtraktion(-1000, 1899));
        assertEquals(-70, testee.subtraktion(-50, 20));
    }

    @After
    public void testAfter()
    {
        testee = null;
    }
}
