import models.DataModel;
import services.parsing.input.ConcreteDataModelParser;
import services.parsing.input.DataModelParser;
import services.reading.ConcreteReader;
import services.reading.SiteReader;
import services.validation.input.ConcreteInputModelValidator;
import services.validation.input.InputModelValidator;
import utilities.Utils;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Utils.setShutDownHook();

        DataModelParser modelParser = new ConcreteDataModelParser();
        DataModel model = modelParser.parse(args);

        InputModelValidator inputModelValidator = new ConcreteInputModelValidator();

        if (!inputModelValidator.isValid(model)) {
            System.exit(-1);
        }

        SiteReader reader = new ConcreteReader();
        try {
            List<String> title = reader.fetchElements(model);
            for (String element: title) {
                System.out.println(element);
            }
        } catch (IOException e) {
            System.exit(-1);
        }


        while (true) {
            Thread.sleep(1000);
            System.out.println("ping");
        }
    }


}
