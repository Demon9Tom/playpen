package tmr.playpen.data.city;

import tmr.playpen.data.Data;

/**
 * This class holds a name and count of students for a single city.
 */
public class City extends Data
{

    /**
     * Build a single city.
     * @param name The name of the city.
     */
    public City(String name)
    {
        super.name     = name;
        super.students = 0;
    }

}
