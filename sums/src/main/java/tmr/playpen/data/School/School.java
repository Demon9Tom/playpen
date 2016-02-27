package tmr.playpen.data.School;

import tmr.playpen.data.Data;

/**
 * This class holds a name and count of students for a single school.
 */
public class School extends Data
{

    /**
     * Build a single school.
     * @param name The name of the school.
     */
    public School(String name)
    {
        super.name     = name;
        super.students = 0;
    }

}