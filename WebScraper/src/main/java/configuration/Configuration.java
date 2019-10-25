package configuration;


import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
    private final String htmlElement;
    private final Boolean enableMultipleElements;
    private final Long delay;
    private final TimeUnit timeUnit;

    private static final Logger logger = Logger.getLogger(Configuration.class.getName());

    private Configuration() throws IOException, NumberFormatException {

        properties.load(new FileInputStream(path));

        argumentCount = Integer.parseInt(properties.getProperty("services.parsers.input.argumentCount"));
        urlIndex = Integer.parseInt(properties.getProperty("services.parsers.input.urlIndex"));
        timeIndex = Integer.parseInt(properties.getProperty("services.parsers.input.timeIndex"));
        defaultHttpEnabled = Boolean.valueOf(properties.getProperty("services.parsers.input.defaultHttpEnabled"));
        minSleepTime = Integer.parseInt(properties.getProperty("services.validators.input.rules.checkTimeRule.minSleepTime"));
        desiredProtocols = properties.getProperty("services.parsers.input.desiredProtocols").split(",");
        defaultProtocol = properties.getProperty("services.parsers.input.defaultProtocol");
        htmlElement = properties.getProperty("services.readers.concreteReader.htmlTag");
        enableMultipleElements = Boolean.valueOf(properties.getProperty("services.readers.concreteReader.enableMultipleElements"));
        timeUnit = TimeUnit.valueOf(properties.getProperty("services.taskManagers.taskManager.timeUnit").toUpperCase());
        delay = Long.parseLong(properties.getProperty("services.taskManagers.taskManager.delay"));
    }

    public static Configuration get() {
        try {
            if (instance == null) {
                instance = new Configuration();
                logger.info("Configuration initialized");
            }
        } catch (IOException | NumberFormatException e) {
            logger.error("Configuration initialization failed: "+e);
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

    public String getHtmlElement() {
        return htmlElement;
    }

    public Boolean getEnableMultipleElements() {
        return enableMultipleElements;
    }

    public Long getDelay() {
        return delay;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
