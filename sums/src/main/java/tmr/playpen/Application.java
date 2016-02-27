package tmr.playpen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tmr.playpen.file.Reader;

import java.io.File;

/**
 * Entry point for the Sums application. Used to bootstrap the application.
 */
public class Application
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    // File read in and split to produced required student totals.
    private static final String INPUT_FILE = "C:\\Workspace\\playpen\\sums\\src\\main\\resources\\Sample Input.txt";

    public static void main(String[] args)
    {
        LOGGER.info("Starting Sums application.");

        File inputFile = new File(INPUT_FILE);
        Reader.readFile(inputFile);
    }

}