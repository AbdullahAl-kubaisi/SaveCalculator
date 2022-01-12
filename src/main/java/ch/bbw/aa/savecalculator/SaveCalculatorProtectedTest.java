package ch.bbw.aa.savecalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * this class will test only protected method's of this package (example of protected package)
 */
public class SaveCalculatorProtectedTest {
    private SaveCalculator testee;

    // create saveCalculator object before all test begin to insure that testee not null
    @Before
    public void setUp() {
        testee = new SaveCalculator();
    }

    // calculating power of number by calling a protected method
    @Test
    public void testProtectedPower() {
        assertEquals(32, testee.pow(2, 5));
    }

    @After
    public void testAfter() {
        testee = null;
    }
}
