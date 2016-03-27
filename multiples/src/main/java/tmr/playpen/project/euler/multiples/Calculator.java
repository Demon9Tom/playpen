package tmr.playpen.project.euler.multiples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

        List<Integer> threeMultiples = getMultiplesOf(3, upperBound);
        List<Integer> fiveMultiples  = getMultiplesOf(5, upperBound);

        // Combine the two Lists of multiples into a set to remove any duplicates.
        Set<Integer> multiples = new HashSet<>();
        multiples.addAll(threeMultiples);
        multiples.addAll(fiveMultiples);

        // Calculate the result.
        int sum = sumIntegerLists(multiples);
        LOGGER.info("Result = {}", sum);
    }

    public int sumIntegerLists(Set<Integer> multiples)
    {
        int sum = 0;
        for (Integer value : multiples)
        {
            sum += value;
        }
        return sum;
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
    public List<Integer> getMultiplesOf(int multiple, int upperBound)
    {
        List<Integer> multiples = new ArrayList<>();

        int i = 1;

        // Start with the value of multiple since lower values couldn't possible be multiples.
        for (int value = multiple ; value < upperBound ; value = multiple * i)
        {
            LOGGER.info("Value = {}", value);
            if (isMultiple(value, multiple))
            {
                multiples.add(value);
            }

            i++;
        }

        LOGGER.info("Retuning Multiples of {}, up to, and excluding upper bound {}. Result = {}", multiple, upperBound, multiples);
        return multiples;
    }

    /**
     * Checks if the given value is a multiple of the given multiple.
     * @param value The value to determine if it is a multiple.
     * @param multiple Determine if value is a multiple of this value.
     * @return True if value is a multiple of the multiple parameter. False otherwise.
     */
    public boolean isMultiple(int value, int multiple)
    {
        boolean result = ( value % multiple ) == 0;
        LOGGER.debug("Is value '{}' multiple of '{}'? result = {}", value, multiple, result);
        return result;
    }

    public boolean isEven(int value)
    {
        boolean result = ( value % 2 ) == 0;
        LOGGER.debug("Is value '{}' even? Result = {}", value, result);
        return result;
    }

}