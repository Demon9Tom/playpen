package tmr.playpen.fibonacci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry point for the Fibonacci application. Used to bootstrap the application.
 */
public class Application
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args)
    {
        LOGGER.info("Starting Fibonacci application.");
        Calculate calculate = new Calculate();
        calculate.process();
    }

}