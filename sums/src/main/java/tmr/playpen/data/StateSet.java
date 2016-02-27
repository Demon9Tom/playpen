package tmr.playpen.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * The class holds a Set of {@link State}s and exposes methods to retrieve existing states. If a calling class attempts
 * to retrieve a {@link State} that does not exist it is created and returned.
 */
public class StateSet
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StateSet.class);

    // Using a set here to ensure uniqueness of States.
    private final Set<State> states = new HashSet<>();

    /**
     * Returns a {@link State} with the given stateName.
     * @param stateName The name of the State to retrieve.
     * @return If a {@link State} with the given state name exists it is returned. Otherwise a new {@link State} is created.
     */
    public State getState(String stateName)
    {
        // If a state with the given name already exists. Return it.
        for (State state : states)
        {
            if (state.getName().equals(stateName))
            {
                return state;
            }
        }

        // Otherwise return a new state.
        return addState(stateName);
    }

    /**
     * Create a new State with the given name. Adding it to the the list of states held by this class.
     * @param stateName The name to give the created {@link State}.
     * @return The {@link State} object created by this method.
     */
    private State addState(String stateName)
    {
        State state = new State(stateName);
        states.add(state);

        LOGGER.info("Created new State = {}. Added to list of states.", state);
        return state;
    }

}