package tmr.playpen.fibonacci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Define various implementation capable of calculating the nth position in the Fibonacci sequence.
 */
public class Calculate
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Calculate.class);

    // The generated Fibonacci sequence.
    private List<Integer> sequence;

    // A count of the members of the sequence.
    private int count = 0;

    public Calculate()
    {
        // Initialize the sequence.
        this.sequence = new ArrayList<>();
        sequence.add(0);
        sequence.add(1);
    }

    /**
     * Returns the value in the given position of the sequence.
     * @param position The position (starting from index 0) to retrieve.
     * @return The value at the given position.
     */
    public int getNthNumberWithLoops(int position)
    {
        // Start at two since we always have the first and second value of the sequence set.
        int i = 2;
        while (i <= position)
        {
            sequence.add(calculateFibonacci());
            i++;
        }
        return sequence.get(position);
    }

    /**
     * Returns the value in the given position of the sequence recursively using no loops or variables.
     *
     * The recursion if terminated once the size of the sequence - 1 matches the position requested by the caller.
     * Minus 1 as the size of the List does not count from 0 like the index position.
     *
     * @param position The position (starting from index 0) to retrieve.
     * @return The value at the given position.
     */
    public int getNthNumberNoLoops(int position)
    {
        LOGGER.debug("Position = {}, Sequence.size() = {}", position, sequence.size());

        // Terminate recursion if at requested position.
        if (isNthPosition(position))
        {
            return sequence.get(position);
        }

        // Add the sequence value for this position and recurse.
        sequence.add(calculateFibonacci());
        return getNthNumberNoLoops(position);
    }

    /**
     * Generates a sum total of all even values in the Fibonacci Sequence up to the given upperBound.
     * @param upperBound Generate the Fibonacci Sequence up to no higher than this value.
     * @return The sum of all even values of the Fibonacci sequence up to upper bound.
     */
    public int evenFibonacci(int upperBound)
    {
        LOGGER.info("Building Sequence of Even Fibonacci numbers and totalling values. Upper Bound '{}', Count '{}'", upperBound, count);

        // Terminate recursion if at requested position.
        if (count >= upperBound)
        {
            return count;
        }

        // Add the sequence value for this position and recurse.
        int value = calculateFibonacci();
        LOGGER.debug("Added Fibonacci value = {}", value);
        sequence.add(value);

        // TODO: Add a Predicate here to determine the condition under which to add to count.
        if (isEven(value))
        {
            count += value;
        }

        return evenFibonacci(upperBound);
    }

    /**
     * Checks if we are at the position requested.
     * @param position The current position.
     * @return True if the position is equal to sequence.size -1. False otherwise.
     */
    public boolean isNthPosition(int position)
    {
        boolean result = position == (sequence.size() -1);
        LOGGER.trace("Is Nth Position '{}'. Returning result = {}", position, result);
        return result;
    }

    /**
     * Calculates the next position in the Fibonacci sequence.
     *
     * Example:
     * If we have 0, 1, 1
     * This method would return 2 (1 + 1);
     * @return (n minus 1) plus (n minus 2);
     */
    public int calculateFibonacci()
    {
        int nMinusOne = sequence.get(sequence.size() - 1);
        int nMinusTwo = sequence.get(sequence.size() - 2);
        int result    = nMinusOne + nMinusTwo;
        LOGGER.debug("Calculating Fibonacci value. (nMinusOne) {} - (nMinusTwo) {} = {}", nMinusOne, nMinusTwo, result);
        return result;
    }

    /**
     * Determines if the given value is an even number.
     * @param value The value to test.
     * @return True if even, false if odd.
     */
    public boolean isEven(int value)
    {
        boolean result = ( value % 2 ) == 0;
        LOGGER.debug("Is value '{}' even? Result = {}", value, result);
        return result;
    }

    // TODO: Write the same function, but the last statement must be a recursive function call. The result of the
    // recursion is returned as-is; it is not transformed in any way, or added to anything. This is a concept called
    // tail recursion, and can be used to optimize processing in languages and compilers that support it.

    // Simple getters and setters.

    public List<Integer> getSequence()
    {
        return sequence;
    }

    public int getCount()
    {
        return count;
    }
}