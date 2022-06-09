package graphics;

import java.awt.*;
import java.util.concurrent.*;

public class ThreadPool extends Component {
    private int corePoolSize;
    private int maxPoolSize;
    private int keepAliveTime;
    private ExecutorService threadPoolExecutor;
    private volatile BlockingQueue<Runnable> linkedBlockingQueue;

    public ThreadPool(int corePoolSize, int maxPoolSize) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.linkedBlockingQueue = new LinkedBlockingQueue<>(maxPoolSize);
        this.threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, corePoolSize, 1,
                TimeUnit.MINUTES, linkedBlockingQueue);
    }

    public boolean addToPool(Runnable other)
    {
        try {
            this.threadPoolExecutor.execute(other);
            return true;
        } catch (RejectedExecutionException e) {
            return false;
        }
    }
}
