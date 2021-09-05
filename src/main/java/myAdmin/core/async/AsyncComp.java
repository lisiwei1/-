package myAdmin.core.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 异步组件
 */
@Component
public class AsyncComp {

    @Autowired
    private TaskPool taskPool;

    public void execute(Runnable runnable) {
        taskPool.execute(runnable);
    }

    public <V> FutureTask<V> submit(Callable<V> callable) {
        FutureTask<V> futureTask = new FutureTask<>(callable);
        taskPool.execute(futureTask);
        return futureTask;
    }

}
