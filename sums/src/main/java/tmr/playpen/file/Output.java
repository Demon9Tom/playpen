package tmr.playpen.file;

import tmr.playpen.data.Data;

/**
 * This class outputs the processed student numbers to the console.
 */
public class Output
{

    // The values from the previous call to the Output class.
    private Data previousState;
    private Data previousCity;
    private Data previousSchool;

    /**
     * If the given object does not match the state field or their are no further values in the input list print.
     * @param newState The state to potential print.
     * @param hasNext True indicates there is further lines to expect form the file. False means there are no more.
     */
    public void printStateTotal(Data newState, boolean hasNext)
    {
        if (shouldOutput(this.previousState, newState, hasNext))
        {
            printTotalToConsole(this.previousState);
        }
        this.previousState = newState;
    }

    /**
     * If the given object does not match the city field or their are no further values in the input list print.
     * @param newCity The city to potential print.
     * @param hasNext True indicates there is further lines to expect form the file. False means there are no more.
     */
    public void printCityTotal(Data newCity, boolean hasNext)
    {
        if (shouldOutput(this.previousCity, newCity, hasNext))
        {
            printTotalToConsole(this.previousCity);
        }
        this.previousCity = newCity;
    }

    /**
     * If the given object does not match the school field or their are no further values in the input list print.
     * @param newSchool The school to potential print.
     * @param hasNext True indicates there is further lines to expect form the file. False means there are no more.
     */
    public void printSchoolTotal(Data newSchool, boolean hasNext)
    {
        if (shouldOutput(this.previousSchool, newSchool, hasNext))
        {
            printTotalToConsole(this.previousSchool);
        }
        this.previousSchool = newSchool;
    }

    /**
     * Print the given class.
     * @param clazz The class to print.
     */
    private <T> void printTotalToConsole(T clazz)
    {
        System.out.println(clazz);
    }

    /**
     * Checks if the given {@link Data} objects should result in the student totals being printed.
     *
     * Since the input file is sorted. If we receive a new {@link Data} object (i.e. one that does not match the one
     * we have stored in the field) then we have exhausted the values for the school, city, or state, thus it should
     * be printed.
     *
     * @param oldValue The previous {@link Data} object that was held by this class.
     * @param newValue The new {@link Data} object passed to this class.
     * @param hasNext True indicates there is further lines to expect form the file. False means there are no more.
     * @return True if the given object should be output. False otherwise.
     */
    private boolean shouldOutput(Data oldValue, Data newValue, boolean hasNext)
    {
        return oldValue != null && (!oldValue.equals(newValue) || !hasNext);
    }

}