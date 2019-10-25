package services.validators.input;

import models.Data;
import org.apache.log4j.Logger;
import services.validators.input.rules.InputRuleFactory;

public class ConcreteInputModelValidator implements InputModelValidator {

    private static final Logger logger = Logger.getLogger(ConcreteInputModelValidator.class.getName());

    @Override
    public void validate(Data model) throws IllegalArgumentException {
        InputRuleFactory
                .getAll()
                .stream()
                .forEach(rule -> {
                    logger.info("Applying rule - " + rule.getClass().getSimpleName());
                    rule.validate(model);
                });
    }
}
