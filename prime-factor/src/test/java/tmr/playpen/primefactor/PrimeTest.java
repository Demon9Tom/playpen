package tmr.playpen.primefactor;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the {@link Prime} class.
 */
public class PrimeTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PrimeTest.class);

    // Numbers for testing:
    private static final List<Integer> primes    = newArrayList(2, 3, 5, 7, 11, 13, 17);
    private static final List<Integer> notPrimes = newArrayList(1, 4, 6, 8, 9, 10, 12, 14, 15, 16);

    /**
     * Unit test for {@link Prime#isPrime(int, int)}.
     *
     * Tests:
     * - Prime numbers pass the test.
     * - Non-Prime numbers fail the test.
     */
    @Test
    public void isPrime()
    {
        // Ensure prime numbers pass the test.
        for (int number : primes)
        {
            assertTrue(Prime.isPrime(number, 2));
        }

        // Ensure non-prime numbers fail the test.
        for (int number : notPrimes)
        {
            assertFalse(Prime.isPrime(number, 2));
        }
    }
}