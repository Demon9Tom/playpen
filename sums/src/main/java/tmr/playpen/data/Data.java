package tmr.playpen.data;

import tmr.playpen.data.School.School;
import tmr.playpen.data.State.State;
import tmr.playpen.data.city.City;

/**
 * Super class for the four Data container classes:
 *  - {@link City}
 *  - {@link School}
 *  - {@link State}
 *
 *  Defines functions for adding students to the total held by the Data object.
 */
public class Data
{

    // The name of this state.
    protected String name;

    // The number of red haired students in this state.
    protected long students;

    protected Data()
    {
    }

    /**
     * Build a single Data object.
     * @param name The name of the data container.
     */
    public Data(String name)
    {
        this.name     = name;
        this.students = 0;
    }

    /**
     * Add students to this Data containers total.
     * @param students The number of students to add.
     */
    public void addStudents(long students)
    {
        this.students += students;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name + " " + students;
    }

}
