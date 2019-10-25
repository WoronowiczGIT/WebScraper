package services.validators.input.rules;

import java.util.ArrayList;
import java.util.List;

public class InputRuleFactory {

    public static List<InputRule> getAll() {
        List<InputRule> rules = new ArrayList<>();

        rules.add(new CheckForNullsRule());
        rules.add(new CheckUrlFormatRule());
        rules.add(new CheckTimeFormatRule());
        return rules;
    }
}
