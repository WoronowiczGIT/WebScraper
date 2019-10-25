package services.validators.input.rules;

import models.Data;


public class CheckForNullsRule implements InputRule{
    @Override
    public void validate(Data data) {
        if(data.getUrl() == null || data.getTime() == null){
            throw new IllegalArgumentException("Null as parameter");
        }
    }
}
