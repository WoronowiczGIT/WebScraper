package services.parsing.input;

import configuration.Configuration;
import models.DataModel;

public class ConcreteDataModelParser implements DataModelParser {
    private final int expectedArgumentsCount = Configuration.get().getArgumentCount();
    private final int urlIndex = Configuration.get().getUrlIndex();
    private final int timeIndex = Configuration.get().getTimeIndex();

    private final boolean defaultHttpEnabled = Configuration.get().getDefaultHttpEnabled();
    private final String[] desiredProtocols = Configuration.get().getDesiredProtocols();
    private final String defaultProtocol = Configuration.get().getDefaultProtocol();

    @Override
    public DataModel parse(String[] args) {
        if (args != null && args.length == expectedArgumentsCount) {

            String time = args[timeIndex];
            String url = args[urlIndex];
            if (defaultHttpEnabled) {
                url = setProtocol(url);
            }

            return new DataModel.DataModelBuilder()
                    .setUrl(url)
                    .setTime(time)
                    .build();
        } else {
            throw new IllegalArgumentException("wrong number of arguments");
        }
    }

    private String setProtocol(String url) {

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
