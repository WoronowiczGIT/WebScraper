package services.reading;

import models.DataModel;

import java.io.IOException;
import java.util.List;

public interface SiteReader {

    List<String> fetchElements(DataModel model) throws IOException;
}
