package services.validators.input.rules;

import models.Data;

public interface InputRule {

    void validate(Data data);
}
