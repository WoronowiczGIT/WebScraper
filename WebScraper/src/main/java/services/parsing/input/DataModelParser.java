package services.parsing.input;

import models.DataModel;

public interface DataModelParser {

    DataModel parse(String[] args);
}
