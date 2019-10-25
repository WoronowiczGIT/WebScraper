package services.validation.input.rules;

import models.DataModel;
import org.apache.commons.validator.routines.UrlValidator;

public class CheckUrlFormatRule implements InputRule {
    private final UrlValidator urlValidator = new UrlValidator();

    @Override
    public void validate(DataModel data) throws IllegalArgumentException{
        String url = data.getUrl();
        if(!urlValidator.isValid(url)){
            throw new IllegalArgumentException("Invalid Url address");
        }
    }
}
