package services.reading;

import models.Data;
import models.DataModel;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ConcreteReaderTest {
    private SiteReader reader;

    @Before
    public void setUp(){
        reader = new ConcreteReader();
    }

    @Test
    public void readTitle() throws IOException {
        String url ="http://www.wp.pl";

        List<String> title = reader.fetchElements(url);
        System.out.println("title is " + title.get(0));
    }
}
