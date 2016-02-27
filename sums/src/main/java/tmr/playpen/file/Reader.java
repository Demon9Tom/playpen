package tmr.playpen.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tmr.playpen.data.Data;
import tmr.playpen.data.DataSet;
import tmr.playpen.data.School.SchoolSet;
import tmr.playpen.data.State.StateSet;
import tmr.playpen.data.city.CitySet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * This class is responsible for reading in the given file line-by-line.
 */
public class Reader
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);

    // Keys for the Map produced by splitting the input lines.
    private static final String STATE_KEY    = "State";
    private static final String CITY_KEY     = "City";
    private static final String SCHOOL_KEY   = "School";
    private static final String GRADE_KEY    = "Grade";
    private static final String STUDENTS_KEY = "Students";

    // Line separator used for splitting the input lines.
    private static final String LINE_SEPARATOR = ",";

    /**
     * Reads in the value of the INPUT_FILE.
     *
     * Note: We are using {@link Scanner} here rather than {@link Stream} or other Java NIO classes due to the
     * requirement to read the file line-by-line as opposed to reading the file in completely and then converting it to a
     * list.
     * @param inputFile The file to read from.
     */
    public static void readFile(File inputFile)
    {

        Output output = new Output();

        LOGGER.info("Reading contents of file = {}");

        DataSet schools = new SchoolSet();
        DataSet cities  = new CitySet();
        DataSet states  = new StateSet();

        try (Scanner scanner = new Scanner(inputFile))
        {

            while (scanner.hasNext())
            {
                String line = scanner.nextLine();

                Map<String, String> splitLine = splitLine(line, LINE_SEPARATOR);

                // Retrieve the values from the Map.
                String schoolName = splitLine.get(SCHOOL_KEY);
                String cityName   = splitLine.get(CITY_KEY);
                String stateName  = splitLine.get(STATE_KEY);
                long students     = Long.parseLong(splitLine.get(STUDENTS_KEY));

                // Add the students to the school object.
                Data school = schools.getObject(schoolName);
                school.addStudents(students);

                // Add the students to the city object.
                Data city = cities.getObject(cityName);
                city.addStudents(students);

                // Add the students to the state object.
                Data state = states.getObject(stateName);
                state.addStudents(students);

                // Output each of the values if it is the final value.
                output.printSchoolTotal(school, scanner.hasNext());
                output.printCityTotal  (city,   scanner.hasNext());
                output.printStateTotal (state,  scanner.hasNext());
            }

        }

        catch (IOException e)
        {
            LOGGER.error("Could not read input file.");
            LOGGER.debug("IO Exception thrown whilst attempting to read file = {}", inputFile);
        }

    }

    /**
     * Split the given line on the given separator.
     *
     * Produces a map in the form:
     *  {
     *      STATE_KEY={stateName},
     *      CITY_KEY={cityName},
     *      SCHOOL_KEY={schoolName},
     *      GRADE_KEY={gradeName},
     *      STUDENTS_KEY={studentCount},
     *  }
     *
     * @param line The line to split.
     * @param separator The separator to use to split the line.
     * @return A map containing the split values of the given line in the form detailed above.
     */
    private static Map<String, String> splitLine(String line, String separator)
    {
        LOGGER.debug("Line to split '{}' using separator '{}'", line, separator);

        // Split the line into an array of Strings.
        String[] arr      = line.split(separator);
        String stateName  = arr[0];
        String cityName   = arr[1];
        String schoolName = arr[2];
        String gradeName  = arr[3].substring(0, 1);
        String students   = arr[3].substring(1);

        // Build the Map to hold the split values.
        Map<String, String> lineMap = new HashMap<>();
        lineMap.put(STATE_KEY,    stateName);
        lineMap.put(CITY_KEY,     cityName);
        lineMap.put(SCHOOL_KEY,   schoolName);
        lineMap.put(GRADE_KEY,    gradeName);
        lineMap.put(STUDENTS_KEY, students);

        LOGGER.debug("Returning Map constructed from line. Map = {}", lineMap);
        return lineMap;
    }

}