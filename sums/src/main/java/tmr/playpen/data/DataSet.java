package tmr.playpen.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a generic container for Data objects.
 *
 * The class holds a Set of {@link Data} objects and exposes methods to retrieve existing objects. If a calling class
 * attempts to retrieve a {@link Data} object that does not exist it is created and then returned.
 */
public class DataSet
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSet.class);

    // Using a set here to ensure uniqueness of the objects.
    private final Set<Data> objects = new HashSet<>();

    /**
     * Returns a {@link Data} object with the given name.
     * @param name The name of the object to retrieve.
     * @return If a {@link Data} with the given name exists it is returned. Otherwise a new {@link Data} object is created.
     */
    public Data getObject(String name)
    {
        // If an object with the given name already exists. Return it.
        for (Data data : objects)
        {
            if (data.getName().equals(name))
            {
                return data;
            }
        }

        // Otherwise return a new object.
        return addObject(name);
    }

    /**
     * Create a new {@link Data} object with the given name. Adding it to the the list of objects held by this class.
     * @param name The name to give the created {@link Data} object.
     * @return The {@link Data} object created by this method.
     */
    private Data addObject(String name)
    {
        Data data = new Data(name);
        objects.add(data);
        LOGGER.info("Created new Data object = {}. Added to list of objects.", data);
        return data;
    }

}
