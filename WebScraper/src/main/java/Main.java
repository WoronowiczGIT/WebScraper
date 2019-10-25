import models.Data;
import models.DataModel;
import org.apache.log4j.Logger;
import services.managing.ConcreteTaskManager;
import services.managing.TaskManager;
import services.managing.tasks.HtmlElementPresenter;
import services.managing.tasks.TimedTask;
import services.parsing.input.ConcreteDataModelParser;
import services.parsing.input.DataModelParser;
import services.presenting.ConsolePresenter;
import services.reading.ConcreteReader;
import services.validation.input.ConcreteInputModelValidator;
import services.validation.input.InputModelValidator;
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
