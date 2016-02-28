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
     * Provide a Constructor for the unit testing, allowing a sequence to be passed in.
     * @param sequence The List to hold the Fibonacci sequence.
     */
    public Calculate(List<Integer> sequence)
    {
        // Initialize the sequence.
        this.sequence = sequence;
    }

    public void process()
    {
        LOGGER.info("Nth Number = {}", getNthNumberWithLoops(5));
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
            int nMinusOne = sequence.get(i - 1);
            int nMinusTwo = sequence.get(i - 2);
            int n = nMinusOne + nMinusTwo;
            sequence.add(n);
            i++;
        }
        return sequence.get(position);
    }

    /**
     * Returns the value in the given position of the sequence recursively.
     * Uses no loops and variables are only set once never reassigned.
     * @param position The position (starting from index 0) to retrieve.
     * @return The value at the given position.
     */
    public int getNthNumberNoLoops(int position)
    {
        LOGGER.info("Position = {}, Sequence.size() = {}", position, sequence.size());

        // Terminate the recursion if the length of the sequence matches the position requested by the caller.
        // Minus 1 as size does not count from 0 like the index.
        if (position == sequence.size() -1)
        {
            return sequence.get(position);
        }

        int nMinusOne = sequence.get(sequence.size() - 1);
        int nMinusTwo = sequence.get(sequence.size() - 2);
        int n = nMinusOne + nMinusTwo;
        sequence.add(n);

        return getNthNumberNoLoops(position);
    }

    /**
     * Returns the value in the given position of the sequence recursively using no loops or variables.
     * @param position The position (starting from index 0) to retrieve.
     * @return The value at the given position.
     */
    public int getNthNumberNoLoopsOrVariables(int position)
    {
        LOGGER.info("Position = {}, Sequence.size() = {}", position, sequence.size());

        // Terminate the recursion if the length of the sequence matches the position requested by the caller.
        // Minus 1 as size does not count from 0 like the index.
        if (position == sequence.size() -1)
        {
            return sequence.get(position);
        }

        // Add the sequence value for position sequence.size().
        sequence.add( (sequence.get(sequence.size() - 1)) + (sequence.get(sequence.size() - 2)) );
        return getNthNumberNoLoopsOrVariables(position);
    }

}