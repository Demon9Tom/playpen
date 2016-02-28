package tmr.playpen.fibonacci;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit tests for the {@link Calculate} class.
 */
public class CalculateTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateTest.class);

    // The object under test.
    private Calculate calculate;

    @Before
    public void init()
    {
        // Initialize the sequence.
        List<Integer> testSequence = new ArrayList<>();
        testSequence.add(0);
        testSequence.add(1);

        // Object under test.
        calculate = new Calculate(testSequence);
    }

    /**
     * Test that the expected values are in the initial positions of the sequence.
     */
    @Test
    public void getNthNumberWithLoops()
    {
        assertEquals("Index 5 should contain value 5.", 5, calculate.getNthNumberWithLoops(5));
    }

    /**
     * Test that the expected values are in the initial positions of the sequence.
     */
    @Test
    public void getNthNumberNoLoops()
    {
        assertEquals("Index 5 should contain value 5.", 5, calculate.getNthNumberNoLoops(5));
    }

}