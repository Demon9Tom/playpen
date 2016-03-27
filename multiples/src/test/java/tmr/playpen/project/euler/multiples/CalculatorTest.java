package tmr.playpen.project.euler.multiples;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.collections.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static java.util.Collections.emptySet;
import static org.junit.Assert.*;

/**
 * TODO:
 */
public class CalculatorTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTest.class);

    // Class under test.
    private Calculator calculator;

    private static final int MULTIPLIER_MAX = 100;

    @Before
    public void initialise()
    {
        calculator = new Calculator();
    }

    /**
     * Unit test for {@link Calculator#sumList(Set)}.
     *
     * Tests:
     * - Empty list total is 0.
     * - Set {1, 2, 3} total equals 6.
     * - Set {500, 1000, 1500} total equals 3000.
     */
    @Test
    public void sumList()
    {
        assertEquals(0, emptySet().size());

        Set<Integer> set1 = Sets.newSet(1, 2, 3);
        assertEquals(6, Calculator.sumList(set1));

        Set<Integer> set2 = Sets.newSet(500, 1000, 1500);
        assertEquals(3000, Calculator.sumList(set2));
    }

    /**
     * Unit test for {@link Calculator#getMultiplesOf(int, int)}.
     */
    @Test
    public void getMultiplesOf()
    {

    }

    /**
     * Unit test for {@link Calculator#isMultiple(int, int)}}.
     *
     * Tests:
     * - That multipliers 1 to MULTIPLIER_MAX return the correct result.
     */
    @Test
    public void isMultiple()
    {
        for (int multiplier = 1; multiplier < MULTIPLIER_MAX; multiplier++)
        {
            int total = 0;
            for (; total < 1000; total += multiplier)
            {
                LOGGER.info("Total: '{}', multiple '{}'", total, multiplier);
                assertTrue("Total * Multiplier should always produce a true result.", Calculator.isMultiple(total, multiplier));
            }
        }
    }

    /**
     * Unit test for {@link Calculator#isEven(int)}}.
     *
     * Tests:
     * - All even numbers up to MULTIPLIER_MAX produce true results.
     * - All odd numbers up to MULTIPLIER_MAX produce false results.
     */
    @Test
    public void isEven()
    {
        // Test even multipliers up tp MULTIPLIER_MAX.
        for (int multiplier = 2; multiplier < MULTIPLIER_MAX; multiplier += 2)
        {
            LOGGER.info("Is Multiplier: '{}' even?", multiplier);
            assertTrue("Should always produce a true result as we are testing with true numbers only.", Calculator.isEven(multiplier));
        }

        // Test odd multipliers up tp MULTIPLIER_MAX.
        for (int multiplier = 3; multiplier < MULTIPLIER_MAX; multiplier += 2)
        {
            LOGGER.info("Is Multiplier: '{}' even?", multiplier);
            assertFalse("Should always produce a false result as we are testing with odd numbers only.", Calculator.isEven(multiplier));
        }
    }

}