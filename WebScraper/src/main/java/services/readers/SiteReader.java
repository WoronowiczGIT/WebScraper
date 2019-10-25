package services.readers;

import java.io.IOException;
import java.util.List;

public interface SiteReader {

    List<String> fetchElements(String url) throws IOException;
}
