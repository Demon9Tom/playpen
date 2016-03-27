package tmr.playpen.project.euler.multiples;

import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Implements the calculation functionality for this project.
 */
public class Calculator
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    public void process()
    {
        int upperBound = 1000;

        Set<Integer> threeMultiples = getMultiplesOf(3, upperBound);
        Set<Integer> fiveMultiples  = getMultiplesOf(5, upperBound);

        // Combine the two Lists of multiples into a set to remove any duplicates.
        Set<Integer> multiples = Sets.newHashSet();
        multiples.addAll(threeMultiples);
        multiples.addAll(fiveMultiples);

        // Calculate the result.
        int sum = sumList(multiples);
        LOGGER.info("Result = {}", sum);
    }

    /**
     * Sums all Integers in the given Set.
     * @param values A set of values to sum.
     * @return The values of the set summed.
     */
    public static int sumList(Set<Integer> values)
    {
        return values.stream().reduce(0, Integer::sum);
    }

    /**
     * Returns a list of all multiples of multiple up to the upper bound.
     *
     * Example:
     * multiple   = 3
     * upperBound = 10
     *
     * Return = 3, 6, 9
     *
     * Works by multiplying the multiple parameter by the number of iterations of the loop, e.g.
     *
     * 1 x 3
     * 2 x 3
     * 3 x 3
     * etc.
     *
     * This means that we only check multiples of the given value rather than all values from zero upperBound.
     *
     * @param multiple The multiple to find multiples of.
     * @param upperBound Continuing finding multiple up to and excluding this upper bound.
     * @return All multiples of multiple up to and excluding the given upper bound.
     */
    public static Set<Integer> getMultiplesOf(int multiple, int upperBound)
    {
        Set<Integer> multiples = Sets.newHashSet();

        int i = 1;

        // Start with the value of multiple since lower values couldn't possible be multiples.
        for (int value = multiple ; value < upperBound ; value = multiple * i)
        {
            LOGGER.info("Value = {}", value);
            if (isDivisibleBy(value, multiple))
            {
                multiples.add(value);
            }

            i++;
        }

        LOGGER.info("Retuning Multiples of {}, up to, and excluding upper bound {}. Result = {}", multiple, upperBound, multiples);
        return multiples;
    }

    /**
     * Determines if the given value is an even number.
     * @param value The value to test.
     * @return True if even, false if odd.
     */
    public static boolean isEven(int value)
    {
        boolean result = isDivisibleBy(value, 2);
        LOGGER.debug("Is value '{}' even? Result = {}", value, result);
        return result;
    }

    /**
     * Checks if the given value is a multiple of the given multiple.
     * @param value The value to determine if it is a multiple.
     * @param multiplier Determine if value is a multiple of this value.
     * @return True if value is a multiple of the multiple parameter. False otherwise.
     */
    public static boolean isDivisibleBy(int value, int multiplier)
    {
        boolean result = ( value % multiplier ) == 0;
        LOGGER.debug("Is value '{}' multiple of '{}'? result = {}", value, multiplier, result);
        return result;
    }
}