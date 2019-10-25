package services.managing;

import models.DataModel;

public interface TaskManager {

    void execute(Runnable task, DataModel model);
}
