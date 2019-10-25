package services.validation.input.rules;

import configuration.Configuration;
import models.DataModel;

public class CheckTimeRule implements InputRule {
    private final Integer minSleepTime = Configuration.get().getMinSleepTime();

    @Override
    public void validate(DataModel data) {
        String time = data.getTime();
        try {
            Integer number = Integer.parseInt(time);
            if (number <= minSleepTime) throw new NumberFormatException("Time value out of scope.");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid time format.");
        }
    }
}
