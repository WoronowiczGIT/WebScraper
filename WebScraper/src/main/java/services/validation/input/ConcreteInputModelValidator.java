package services.validation.input;

import configuration.Configuration;
import models.DataModel;
import org.apache.log4j.Logger;
import services.validation.input.rules.InputRule;
import services.validation.input.rules.InputRuleFactory;

public class ConcreteInputModelValidator implements InputModelValidator {

    private static final Logger logger = Logger.getLogger(ConcreteInputModelValidator.class.getName());

    @Override
    public Boolean isValid(DataModel model) {
        try {
            for (InputRule rule : InputRuleFactory.getAll()) {
                logger.info("Applying rule - "+rule.getClass().getSimpleName());
                rule.validate(model);

            }

        } catch (IllegalArgumentException e) {
            logger.error("validation failed.");
            return false;
        }
        return true;
    }
}
