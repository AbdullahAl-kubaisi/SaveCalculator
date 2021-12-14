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

    }

    @Test
    public void testSummeZweiNegativeIsOk() {
        assertEquals(-30, testee.summe(-10, -20));

    }
    @Test
    public void testSummeEinNegativeEinPositiveIsOk() {
        assertEquals(-30, testee.summe(10, -40));

    }

    @Test
    public void testSubZweiPositiveIsOk() {
        assertEquals(-10, testee.subtraktion(10, 20));

    }

    @Test
    public void testSubZweiNegativeIsOk() {
        assertEquals(10, testee.subtraktion(-10, -20));

    }
    @Test
    public void testSubEinNegativeEinPositiveIsOk() {
        assertEquals(50, testee.subtraktion(10, -40));

    }

    @Test // test will failed here, because the first assertion is wrong
    public void testMultipleAssert()
    {
        assertEquals(12, testee.summe(5,5));
        assertEquals(10, testee.summe(10,5));
        assertEquals(4, testee.summe(2,2));
    }

    @After
    public void testAfter()
    {
        testee = null;
    }
}
