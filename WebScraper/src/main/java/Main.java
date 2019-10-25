import models.DataModel;
import services.parsing.input.ConcreteDataModelParser;
import services.parsing.input.DataModelParser;
import services.reading.Reader;
import services.reading.SiteReader;
import services.validation.input.ConcreteInputModelValidator;
import services.validation.input.InputModelValidator;
import utilities.Utils;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Utils.setShutDownHook();

        DataModelParser modelParser = new ConcreteDataModelParser();
        DataModel model = modelParser.parse(args);

        InputModelValidator inputModelValidator = new ConcreteInputModelValidator();

        if (!inputModelValidator.isValid(model)) {
            System.exit(-1);
        }

        SiteReader reader = new Reader();
        try {
            String title = reader.readTitle(model);
            System.out.println(title);
        } catch (IOException e) {
            System.exit(-1);
        }


        while (true) {
            Thread.sleep(1000);
            System.out.println("ping");
        }
    }


}
