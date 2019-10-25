package services.taskManagers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.taskManagers.tasks.TimedTask;

public class ConcreteTaskManagerTest {
    private TaskManager manager;
    private int counter;

    @Before
    public void setUp(){
        manager = new ConcreteTaskManager();
        counter = 0;
    }

    @Test
    public void execute() throws InterruptedException {
        TimedTask task = new TestTask();
        manager.execute(task);
        Thread.sleep(1000);
        Assert.assertTrue(counter >= 1);
    }

    class TestTask implements TimedTask{

        @Override
        public Long getTime() {
            return 1L;
        }

        @Override
        public void run() {
            counter++;
        }
    }
}
