package tmr.playpen.data;

// TODO: Define uniqueness.
// TODO: Add toString.
/**
 * This class holds a name and count of students for a single state.
 */
public class State
{

    // The name of this state.
    private String name;

    // The number of red haired students in this state.
    private long students;

    /**
     * Build a single state.
     * @param name The name of the state.
     */
    public State(String name)
    {
        this.name = name;
        this.students = 0;
    }

    /**
     * Adds the given students to the total for this State.
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

    public long getStudents()
    {
        return students;
    }

}