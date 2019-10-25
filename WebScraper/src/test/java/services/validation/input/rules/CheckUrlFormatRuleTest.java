package services.validation.input.rules;

import models.DataModel;
import org.junit.Assert;
import org.junit.Test;
import services.parsing.input.ConcreteDataModelParser;


public class CheckUrlFormatRuleTest {
    private InputRule rule = new CheckUrlFormatRule();

    @Test
    public void validate() {
        String time = "10";
        String url = "wp.pl:8080/wp.pl";
        DataModel model = new ConcreteDataModelParser().parse(new String[]{url,time});

        try {
            rule.validate(model);
        }catch (IllegalArgumentException e){
            Assert.assertTrue(false);
        }
    }
}
