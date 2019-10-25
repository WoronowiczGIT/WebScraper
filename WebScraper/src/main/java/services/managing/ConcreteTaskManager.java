package services.managing;

import configuration.Configuration;
import models.DataModel;
import org.apache.log4j.Logger;
import services.reading.ConcreteReader;

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
    public void execute(Runnable task, DataModel model) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Integer time = Integer.parseInt(model.getTime());

        executor.scheduleAtFixedRate(task,delay,time, timeUnit);
        executors.add(executor);
        logger.info("Starting task.");
    }

    @PreDestroy
    private void killExecutors() {
        executors.stream().forEach(e -> e.shutdown());
    }
}