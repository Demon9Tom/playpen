package tmr.playpen.fibonacci;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Stopwatch;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit tests for the {@link Calculate} class.
 */
public class CalculateTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateTest.class);

    // The object under test.
    private Calculate calculate;

    // A stopwatch to time method execution.
    private Stopwatch stopwatch;

    @Before
    public void init()
    {
        calculate = new Calculate();
        stopwatch = Stopwatch.createStarted();
    }

    @After
    public void exit()
    {
        LOGGER.info("Method took: " + stopwatch.stop());
    }

    /**
     * Unit test for {@link Calculate#getNthNumberWithLoops(int)}.
     *
     * Tests:
     * - Correct value is returned for nth position.
     */
    @Test
    public void getNthNumberWithLoops()
    {
        assertEquals("Index 5 should contain value 5.", 5, calculate.getNthNumberWithLoops(5));
    }

    /**
     * Unit test for {@link Calculate#getNthNumberNoLoops(int)}.
     *
     * Tests:
     * - Correct value is returned for nth position.
     */
    @Test
    public void getNthNumberNoLoops()
    {
        assertEquals("Index 5 should contain value 5.", 5, calculate.getNthNumberNoLoops(5));
    }

    /**
     * Unit test for {@link Calculate#getNthNumberNoLoopsOrVariables(int)}.
     *
     * Tests:
     * - Correct value is returned for nth position.
     */
    @Test
    public void getNthNumberNoLoopsOrVariables()
    {
        assertEquals("Index 5 should contain value 5.", 5, calculate.getNthNumberNoLoopsOrVariables(5));
    }

    /**
     * Unit test for {@link Calculate#calculateFibonacci()}.
     *
     * Tests:
     * - Calculation is performed correctly.
     */
    @Test
    public void calculateFibonacci()
    {
        assertEquals("Sequence contains n - 1 = 0 and n - 2 = 1 so should return 1.", 1, calculate.calculateFibonacci());

        // Add values and retest.
        List<Integer> sequence = calculate.getSequence();
        sequence.add(1);
        sequence.add(2);

        assertEquals("Sequence contains n - 1 = 2 and n - 2 = 1 so should return 3.", 3, calculate.calculateFibonacci());
    }
}