package services.validation.input;

import models.DataModel;
import org.apache.log4j.Logger;
import services.validation.input.rules.InputRuleFactory;

public class ConcreteInputModelValidator implements InputModelValidator {

    private static final Logger logger = Logger.getLogger(ConcreteInputModelValidator.class.getName());

    @Override
    public void validate(DataModel model) throws IllegalArgumentException {
        InputRuleFactory
                .getAll()
                .stream()
                .forEach(rule -> {
                    logger.info("Applying rule - " + rule.getClass().getSimpleName());
                    rule.validate(model);
                });
    }
}
