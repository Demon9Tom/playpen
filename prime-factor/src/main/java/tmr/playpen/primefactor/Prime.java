package tmr.playpen.primefactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class determines if a given number is Prime Number.
 */
public class Prime
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Prime.class);

    /**
     * Determines if the given number is prime.
     * A prime number is defined as:
     * - A whole number
     * - Divisible by 1.
     * - Divisible by itself.
     * - Not the number one.
     * @param number The number to test.
     * @return true if the given number is Prime. False otherwise.
     */
    public static boolean isPrime(int number, double i)
    {
        LOGGER.debug("Is Prime Test. Testing number '{}'. Divisible by '{}'", number, i);

        // One is a unity number, not a prime.
        if (number == 1)
        {
            LOGGER.debug("Returning False. 1 is not a prime number.");
            return false;
        }

        // If true number is only divisible by itself.
        if (i == number)
        {
            LOGGER.debug("Returning True.");
            return true;
        }

        boolean isPrime = (number % i) == 0;

        // If true this number is divisible by something other than itself. Thus not prime.
        if (isPrime)
        {
            LOGGER.debug("Returning False. Number '{}' is divisible by '{}'. Not Prime.", number, i);
            return false;
        }

        return isPrime(number, ++i);
    }
}