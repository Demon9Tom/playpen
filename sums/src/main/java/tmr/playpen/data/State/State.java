package tmr.playpen.data.State;

import tmr.playpen.data.Data;

/**
 * This class holds a name and count of students for a single state.
 */
public class State extends Data
{

    /**
     * Build a single state.
     * @param name The name of the state.
     */
    public State(String name)
    {
        super.name     = name;
        super.students = 0;
    }

}