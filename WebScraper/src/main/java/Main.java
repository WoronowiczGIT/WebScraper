import models.Data;
import org.apache.log4j.Logger;
import services.taskManagers.ConcreteTaskManager;
import services.taskManagers.TaskManager;
import services.taskManagers.tasks.HtmlElementPresenter;
import services.taskManagers.tasks.TimedTask;
import services.parsers.input.ConcreteDataModelParser;
import services.parsers.input.DataModelParser;
import services.presenters.ConsolePresenter;
import services.readers.ConcreteReader;
import services.validators.input.ConcreteInputModelValidator;
import services.validators.input.InputModelValidator;
import utilities.Utils;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Utils.setShutDownHook();

        DataModelParser modelParser = new ConcreteDataModelParser();
        InputModelValidator inputModelValidator = new ConcreteInputModelValidator();

        Data model = null;

        try {
            model = modelParser.parse(args);
            inputModelValidator.validate(model);

        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            System.exit(-1);
        }

        TimedTask task = new HtmlElementPresenter(new ConcreteReader(), new ConsolePresenter(), model);
        TaskManager manager = new ConcreteTaskManager();
        manager.execute(task);

    }
}
