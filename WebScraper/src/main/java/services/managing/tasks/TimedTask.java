package services.managing.tasks;

public interface TimedTask extends Runnable {

    Long getTime();
}
