package services.reading;

import models.DataModel;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ConcreteReaderTest {
    private SiteReader reader;

    @Before
    public void setUp(){
        reader = new ConcreteReader();
    }

    @Test
    public void readTitle() throws IOException {

        DataModel model = new DataModel.DataModelBuilder()
                .setUrl("http://www.wp.pl")
                .setTime("500")
                .build();

        String title = reader.fetchElements(model);
        System.out.println("title is " + title);
    }
}
