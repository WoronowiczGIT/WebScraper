package services.validation.input.rules;

import models.DataModel;

public interface InputRule {

    void validate(DataModel data);
}
