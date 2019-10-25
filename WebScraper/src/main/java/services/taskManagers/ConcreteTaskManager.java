package services.taskManagers;

import configuration.Configuration;
import org.apache.log4j.Logger;
import services.taskManagers.tasks.TimedTask;

import javax.annotation.PreDestroy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcreteTaskManager implements TaskManager {
    private static final Logger logger = Logger.getLogger(ConcreteTaskManager.class.getName());
    private final Set<ScheduledExecutorService> executors = new HashSet<>();
    private final TimeUnit timeUnit = Configuration.get().getTimeUnit();
    private final Long delay = Configuration.get().getDelay();

    @Override
    public void execute(TimedTask task) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Long time = task.getTime();

        executor.scheduleAtFixedRate(task,delay,time, timeUnit);
        executors.add(executor);
        logger.info("Starting task.");
    }

    @PreDestroy
    private void killExecutors() {
        executors.stream().forEach(e -> e.shutdown());
    }
}
