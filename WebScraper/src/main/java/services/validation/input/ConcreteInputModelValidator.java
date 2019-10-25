package services.validation.input;

import models.DataModel;
import services.validation.input.rules.InputRule;
import services.validation.input.rules.InputRuleFactory;

public class ConcreteInputModelValidator implements InputModelValidator {

    @Override
    public Boolean isValid(DataModel model) {
        try {
            for (InputRule rule : InputRuleFactory.getAll()) {
                rule.validate(model);
            }

        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
