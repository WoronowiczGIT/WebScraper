package services.validators.input.rules;

import configuration.Configuration;
import models.Data;

public class CheckTimeFormatRule implements InputRule {
    private final Integer minSleepTime = Configuration.get().getMinSleepTime();

    @Override
    public void validate(Data data) {
        String time = data.getTime();
        try {
            Long number = Long.parseLong(time);
            if (number <= minSleepTime) throw new NumberFormatException("Time value out of scope.");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid time format.");
        }
    }
}
