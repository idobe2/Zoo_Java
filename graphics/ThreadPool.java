package graphics;

import animals.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

public class ThreadPool extends Component {
    private int corePoolSize; //= 5;
    private int maxPoolSize; //= 10;
    private int keepAliveTime; //= 5000;
    private ExecutorService threadPoolExecutor;
    private volatile BlockingQueue<Runnable> linkedBlockingQueue;

    public ThreadPool(int corePoolSize, int maxPoolSize) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.linkedBlockingQueue = new LinkedBlockingQueue<Runnable>(maxPoolSize);
        this.threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, corePoolSize, 1,
                TimeUnit.MINUTES, linkedBlockingQueue);
    }

    public boolean addToPool(Runnable other)
    {
        try {   // TODO: How to limit the number of animals in queue?
            this.linkedBlockingQueue.add(other);
            this.threadPoolExecutor.execute(other);
            return true;
        } catch (RejectedExecutionException e) {
            //JOptionPane.showMessageDialog(null, "You cannot add more than " + corePoolSize + "animals");
            return false;
        }
    }

}
