import models.DataModel;
import services.parsing.input.ConcreteDataModelParser;
import services.parsing.input.DataModelParser;
import services.validation.input.ConcreteInputModelValidator;
import services.validation.input.InputModelValidator;
import utilities.Utils;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Utils.setShutDownHook();

        DataModelParser modelParser = new ConcreteDataModelParser();
        DataModel model = modelParser.parse(args);

        InputModelValidator inputModelValidator = new ConcreteInputModelValidator();
        if(inputModelValidator.isValid(model)){

        }else{
            System.exit(-1);
        }

        while (true) {
            Thread.sleep(1000);
            System.out.println("ping");


        }
    }


}
