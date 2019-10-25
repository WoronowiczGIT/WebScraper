package services.taskManagers.tasks;

public interface TimedTask extends Runnable {

    Long getTime();
}
