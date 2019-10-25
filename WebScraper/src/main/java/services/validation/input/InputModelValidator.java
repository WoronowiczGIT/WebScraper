package services.validation.input;

import models.DataModel;

public interface InputModelValidator {

    Boolean isValid(DataModel model);
}
