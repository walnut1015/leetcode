package Other.threadsynchronize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author tanya
 * @date 2018/7/23 16:05
 */
public class BlockingClass {
    static final String str = "";
    private static class ConsumerTask implements Runnable{
        final private Queue<Integer> queue;
        private int maxSize;
        final private String name;
        public ConsumerTask(String name,int maxSize,Queue queue ){
            this.name=name;
            this.queue = queue;
            this.maxSize = maxSize;
        }
        @Override
        public void run(){
            while (true){
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                        finally {
                            System.out.println(name+"返回了");
                            System.out.println(Thread.currentThread().getState());
                        }
                    }
                    System.out.println(name+"取出"+queue.poll());
                    System.out.println(Thread.currentThread().getState());
                    queue.notify();
                }
        }
    }
    }
    private static class ProducerTask implements Runnable{
        final private Queue<Integer> queue;
        private int maxSize;
        final private String name;
        public ProducerTask(String name,int maxSize,Queue queue ){
            this.name=name;
            this.queue = queue;
            this.maxSize = maxSize;
        }
        @Override
        public void run(){
            //while (true){
            for(int i = 0;i<10;i++) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                        try {
                            //只有执行到wait方法的时候才会让出锁，这种生产者-消费者机制不是很好
                            queue.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    int temp = i;
                    queue.offer(temp);
                    System.out.println("生产者放入：" + temp);
                    System.out.println(Thread.currentThread().getState());
                    queue.notify();
                }
            }
            }

    }
    public static void main(String[] args){
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        int maxSize = 10;
        Thread t1 = new Thread(new ConsumerTask("消费者1号",maxSize,queue));
        Thread t2 = new Thread(new ProducerTask("生产者1号",maxSize,queue));
        Thread t3 = new Thread(new ConsumerTask("消费者2号",maxSize,queue));
        t2.start();
        t1.start();
        t3.start();
        try {
            Thread.sleep(300);
            /*t3.stop();
            t1.stop();*/
            System.out.println(t2.getState());
            System.out.println(t1.getState());
            System.out.println(t3.getState());
            /*t3.interrupt();
            t1.interrupt();
            System.out.println(t2.getState());
            System.out.println(t1.getState());
            System.out.println(t3.getState());*/
        } catch (InterruptedException e) {
            Semaphore ee;
            System.out.println("线程被阻塞");
        }
    }
}
