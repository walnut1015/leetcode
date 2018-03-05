package Other.threadsynchronize;

import java.util.concurrent.*;

/**
 * class: BolockingQueueTest
 *
 * @author 刘天雅
 * @date 2018/02/26
 */
public class BolockingQueueTest
{
    private static Factory factory = new Factory();
    public static void main(String[]args)
    {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new produceTask());
        exe.execute(new consumeTask());
        exe.shutdown();
    }

    private static class Factory
    {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(5);
        private int i = 1;
        public void produce()
        {
            try {
                while (true)
                {
                    buffer.offer(i++);
                    System.out.println("生产新物品"+(i-1));
                    Thread.sleep((int) (Math.random() * (10000)));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void consume()
        {
            try {
                while (true)
                {
                    int j = buffer.take();
                    System.out.println("消费新物品"+j);
                    Thread.sleep((int) (Math.random() * (10000)));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static class produceTask implements Runnable
    {
        public void run()
        {
            factory.produce();
        }
    }
    private static class consumeTask implements Runnable
    {
        public void run()
        {
            factory.consume();
        }
    }
}