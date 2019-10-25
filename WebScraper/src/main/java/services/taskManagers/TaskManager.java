package services.taskManagers;

import services.taskManagers.tasks.TimedTask;

public interface TaskManager {

    void execute(TimedTask task);
}
