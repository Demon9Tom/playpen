package tmr.playpen.project.euler.multiples;

import com.google.common.collect.Sets;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static java.util.Collections.emptySet;
import static org.junit.Assert.*;

/**
 * Unit tests for {@link Calculator} class.
 */
public class CalculatorTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTest.class);

    private static final int MULTIPLIER_MAX = 100;

    /**
     * Unit test for {@link Calculator#mergeSets(Set[])}}.
     *
     * Tests:
     * - That two sets merged contain every unique values at most once.
     */
    @Test
    public void mergeSets()
    {
        Set<Integer> threes = Sets.newHashSet(3, 6, 9, 12, 15, 18);
        Set<Integer> fives  = Sets.newHashSet(5, 10, 15);

        Set<Integer> expected = Sets.newHashSet(3, 5, 6, 9, 10, 12, 15, 18);
        Set<Integer> result   = Calculator.mergeSets(threes, fives);

        assertEquals("Should contain all values from combined list, only once.", expected, result);
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
        assertEquals("An empty list should return a zero result.", 0, emptySet().size());

        Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
        assertEquals("1 + 2 + 3 should equal 6.", 6, Calculator.sumList(set1));

        Set<Integer> set2 = Sets.newHashSet(500, 1000, 1500);
        assertEquals("500 + 1000 + 15000 should equal 3000.", 3000, Calculator.sumList(set2));
    }

    /**
     * Unit test for {@link Calculator#getMultiplesOf(int, int)}.
     */
    @Test
    public void getMultiplesOf()
    {
        assertEquals("Should return 3, 6, and 9.", 3, Calculator.getMultiplesOf(3, 10).size());
        assertEquals("Should return 4 and 8.", 2, Calculator.getMultiplesOf(4, 10).size());
        assertEquals("Should return 5 (since we do not include the upper bound).", 1, Calculator.getMultiplesOf(5, 10).size());
        assertTrue("Should be no results as we only included the upper bound.", Calculator.getMultiplesOf(10, 10).isEmpty());
        assertTrue("Should be no results as value is out of bounds.", Calculator.getMultiplesOf(15, 10).isEmpty());
    }

    /**
     * Unit test for {@link Calculator#isDivisibleBy(int, int)}}.
     *
     * Tests:
     * - That multipliers 1 to MULTIPLIER_MAX return the correct result.
     */
    @Test
    public void isDivisibleBy()
    {
        for (int multiplier = 1; multiplier < MULTIPLIER_MAX; multiplier++)
        {
            int total = 0;
            for (; total < 1000; total += multiplier)
            {
                LOGGER.info("Total: '{}', multiple '{}'", total, multiplier);
                assertTrue("Total * Multiplier should always produce a true result.", Calculator.isDivisibleBy(total, multiplier));
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