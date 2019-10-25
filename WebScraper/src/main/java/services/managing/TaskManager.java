package services.managing;

import services.managing.tasks.TimedTask;

public interface TaskManager {

    void execute(TimedTask task);
}
