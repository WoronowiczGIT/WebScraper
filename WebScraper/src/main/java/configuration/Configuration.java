package configuration;


import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static final Properties properties = new Properties();
    private static final String path = ".\\src\\main\\resources\\application.properties";

    private static Configuration instance;

    private final Integer argumentCount;
    private final Integer urlIndex;
    private final Integer timeIndex;
    private final Boolean defaultHttpEnabled;
    private final Integer minSleepTime;
    private final String[] desiredProtocols;
    private final String defaultProtocol;

    private static final Logger logger = Logger.getLogger(Configuration.class.getName());

    private Configuration() throws IOException, NumberFormatException {

        properties.load(new FileInputStream(path));

        argumentCount = Integer.parseInt(properties.getProperty("services.parsing.input.argumentCount"));
        urlIndex = Integer.parseInt(properties.getProperty("services.parsing.input.urlIndex"));
        timeIndex = Integer.parseInt(properties.getProperty("services.parsing.input.timeIndex"));
        defaultHttpEnabled = Boolean.valueOf(properties.getProperty("services.parsing.input.defaultHttpEnabled"));
        minSleepTime = Integer.parseInt(properties.getProperty("services.validation.input.rules.CheckTimeRule.minSleepTime"));
        desiredProtocols = properties.getProperty("services.parsing.input.desiredProtocols").split(",");
        defaultProtocol = properties.getProperty("services.parsing.input.defaultProtocol");
    }

    public static Configuration get(){
        try {
            if (instance == null) {
                instance = new Configuration();
                logger.info("Configuration initialized");
            }
        }catch (IOException | NumberFormatException e){
            logger.error("Configuration initialization failed");
            System.exit(-1);
        }

        return instance;
    }

    public Integer getArgumentCount() {
        return argumentCount;
    }

    public Integer getUrlIndex() {
        return urlIndex;
    }

    public Integer getTimeIndex() {
        return timeIndex;
    }

    public Boolean getDefaultHttpEnabled() {
        return defaultHttpEnabled;
    }

    public Integer getMinSleepTime() {
        return minSleepTime;
    }

    public String[] getDesiredProtocols() {
        return desiredProtocols;
    }

    public String getDefaultProtocol() {
        return defaultProtocol;
    }
}
