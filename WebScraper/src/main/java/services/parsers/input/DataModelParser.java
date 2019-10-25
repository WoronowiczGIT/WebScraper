package services.parsers.input;

import models.DataModel;

public interface DataModelParser {

    DataModel parse(String[] args);
}
