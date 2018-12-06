package Other.threadsynchronize;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tanya
 * @date 2018/9/12 15:37
 */
public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static class Task implements Runnable{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("拿到锁了");
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Task());
        lock.lock();
        t.start();
        t.interrupt();
    }
}
