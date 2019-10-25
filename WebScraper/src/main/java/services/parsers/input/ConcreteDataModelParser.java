package services.parsers.input;

import configuration.Configuration;
import models.DataModel;
import org.apache.log4j.Logger;

public class ConcreteDataModelParser implements DataModelParser {
    private final int expectedArgumentsCount = Configuration.get().getArgumentCount();
    private final int urlIndex = Configuration.get().getUrlIndex();
    private final int timeIndex = Configuration.get().getTimeIndex();

    private final boolean defaultHttpEnabled = Configuration.get().getDefaultHttpEnabled();
    private final String[] desiredProtocols = Configuration.get().getDesiredProtocols();
    private final String defaultProtocol = Configuration.get().getDefaultProtocol();

    private static final Logger logger = Logger.getLogger(ConcreteDataModelParser.class.getName());

    @Override
    public DataModel parse(String[] args){
        if (args != null && args.length == expectedArgumentsCount) {

            String time = args[timeIndex];
            String url = args[urlIndex];
            if (defaultHttpEnabled) {
                url = setDefaultProtocol(url);
            }

            return new DataModel.DataModelBuilder()
                    .setUrl(url)
                    .setTime(time)
                    .build();
        } else {
            logger.error("Failed to parse data model");
            throw new IllegalArgumentException("wrong number of arguments");
        }
    }

    private String setDefaultProtocol(String url) {

        for (String protocol : desiredProtocols) {
            if (url.toLowerCase()
                    .startsWith(protocol.toLowerCase())) {
                return url;
            }
        }

        StringBuilder builder = new StringBuilder(defaultProtocol);
        builder.append(url);
        return builder.toString();

    }
}
