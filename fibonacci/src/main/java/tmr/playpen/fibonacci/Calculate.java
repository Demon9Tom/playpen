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

    private List<Integer> sequence;

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
     * @param position The position (starting from index 0) to retrieve.
     * @return The value at the given position.
     */
    public int getNthNumberNoLoops(int position)
    {
        LOGGER.debug("Position = {}, Sequence.size() = {}", position, sequence.size());

        // TODO: method for this.
        // Terminate the recursion if the length of the sequence matches the position requested by the caller.
        // Minus 1 as size does not count from 0 like the index.
        if (position == sequence.size() -1)
        {
            return sequence.get(position);
        }

        // Add the sequence value for position sequence.size().
        sequence.add(calculateFibonacci());
        return getNthNumberNoLoops(position);
    }

    /**
     * Calculates the next position in the Fibonacci sequence.
     *
     * Example:
     * If we have 0, 1, 1
     * This method would return 2 (1 + 1);
     * @return (n minus 1) add (n minus 2);
     */
    public int calculateFibonacci()
    {
        int nMinusOne = sequence.get(sequence.size() - 1);
        int nMinusTwo = sequence.get(sequence.size() - 2);
        return nMinusOne + nMinusTwo;
    }

    // TODO: Write the same function, but the last statement must be a recursive function call. The result of the
    // recursion is returned as-is; it is not transformed in any way, or added to anything. This is a concept called
    // tail recursion, and can be used to optimize processing in languages and compilers that support it.

    // Simple getters and setters.

    public List<Integer> getSequence()
    {
        return sequence;
    }
}