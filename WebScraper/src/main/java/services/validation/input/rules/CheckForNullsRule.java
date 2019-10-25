package services.validation.input.rules;

import models.DataModel;

public class CheckForNullsRule implements InputRule{
    @Override
    public void validate(DataModel data) {
        if(data.getUrl() == null || data.getTime() == null){
            throw new IllegalArgumentException("Null as parameter");
        }
    }
}
