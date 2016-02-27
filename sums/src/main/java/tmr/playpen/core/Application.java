package tmr.playpen.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tmr.playpen.file.Reader;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Entry point for the Sums application. Used to bootstrap the application.
 */
public class Application
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    // File to process.
    private static final String INPUT_FILE = "/Sample Input.txt";

    public static void main(String[] args) throws URISyntaxException
    {
        LOGGER.info("Starting Sums application.");
        File inputFile = new File(Application.class.getResource(INPUT_FILE).toURI());
        Reader.readFile(inputFile);
    }

}