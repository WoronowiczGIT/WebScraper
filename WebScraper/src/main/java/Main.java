import models.DataModel;
import services.managing.ConcreteTaskManager;
import services.managing.TaskManager;
import services.managing.tasks.HtmlElementPresenter;
import services.parsing.input.ConcreteDataModelParser;
import services.parsing.input.DataModelParser;
import services.presenting.ConsolePresenter;
import services.reading.ConcreteReader;
import services.validation.input.ConcreteInputModelValidator;
import services.validation.input.InputModelValidator;
import utilities.Utils;

public class Main {


    public static void main(String[] args){
        Utils.setShutDownHook();

        DataModelParser modelParser = new ConcreteDataModelParser();
        DataModel model = modelParser.parse(args);

        InputModelValidator inputModelValidator = new ConcreteInputModelValidator();

        if (!inputModelValidator.isValid(model)) {
            System.exit(-1);
        }

        Runnable task = new HtmlElementPresenter(new ConcreteReader(),new ConsolePresenter(),model);
        TaskManager manager = new ConcreteTaskManager();
        manager.execute(task,model);

    }
}
