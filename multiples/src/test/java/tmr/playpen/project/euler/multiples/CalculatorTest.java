package tmr.playpen.project.euler.multiples;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

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
     * Unit test for {@link Calculator#sumIntegerLists(Set)}.
     */
    @Test
    public void sumIntegerLists()
    {

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
                assertTrue("Total * Multiplier should always produce a true result.", calculator.isMultiple(total, multiplier));
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
            assertTrue("Should always produce a true result as we are testing with true numbers only.", calculator.isEven(multiplier));
        }

        // Test odd multipliers up tp MULTIPLIER_MAX.
        for (int multiplier = 3; multiplier < MULTIPLIER_MAX; multiplier += 2)
        {
            LOGGER.info("Is Multiplier: '{}' even?", multiplier);
            assertFalse("Should always produce a false result as we are testing with odd numbers only.", calculator.isEven(multiplier));
        }
    }

}