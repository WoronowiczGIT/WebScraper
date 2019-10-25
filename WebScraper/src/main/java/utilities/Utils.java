package utilities;

import configuration.Configuration;
import org.apache.log4j.Logger;

public class Utils {
    private static final String EXIT_MSG = "Exit signal received.";
    private static final Logger logger = Logger.getLogger(Configuration.class.getName());

    public static void setShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                System.out.println(EXIT_MSG)
        ));
        logger.info("Exit hook initialized.");
    }
}
