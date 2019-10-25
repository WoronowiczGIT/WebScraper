package services.managing;

import models.DataModel;
import services.managing.tasks.TimedTask;

public interface TaskManager {

    void execute(TimedTask task);
}
