package services.reading;

import models.DataModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Reader implements SiteReader{


    @Override
    public String readTitle(DataModel model) throws IOException {
        String url = model.getUrl();
        Document doc = Jsoup.connect(url)
                .followRedirects(true)
                .get();

        return doc.title();
    }
}
