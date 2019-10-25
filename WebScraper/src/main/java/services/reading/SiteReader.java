package services.reading;

import models.DataModel;

import java.io.IOException;

public interface SiteReader {

    String readTitle(DataModel model) throws IOException;
}
