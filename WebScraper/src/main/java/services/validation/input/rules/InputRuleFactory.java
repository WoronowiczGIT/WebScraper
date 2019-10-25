package services.validation.input.rules;

import java.util.ArrayList;
import java.util.List;

public class InputRuleFactory {
    private static final List<InputRule> rules = new ArrayList<>();

    public static List<InputRule> getAll() {
        rules.add(new CheckForNullsRule());
        rules.add(new CheckUrlFormatRule());
        rules.add(new CheckTimeRule());
        return rules;
    }
}
