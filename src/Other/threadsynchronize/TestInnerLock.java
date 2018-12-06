package Other.threadsynchronize;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tanya
 * @date 2018/7/14 16:46
 * 该文件代码主要是为了测试 synchronized(object) 是不是相当于object中的内置锁
 */
public class TestInnerLock {
    private final static Container count = new Container();
    static {
        count.setEle(0);
    }
    private static class InnerLockA implements Runnable{
        @Override
        public void run(){
            add();
        }
        private void add(){
            while (true) {
                synchronized (count) {
                    int a = count.getEle();
                    Thread.yield();
                    count.setEle(a + 1);
                    System.out.println("Thread 1");

                    Thread.yield();
                    a = count.getEle();
                    Thread.yield();
                    count.setEle(a + 1);
                    System.out.println("Thread 1");

                    Thread.yield();
                    a = count.getEle();
                    Thread.yield();
                    count.setEle(a + 1);
                    System.out.println("Thread 1");
                }
            }
        }
    }
    public static class InnerLockB implements Runnable{
        @Override
        public void run(){
            while (true){
                ReentrantLock l = new ReentrantLock();

            count.add();
            Thread.yield();
            }
        }
    }

    static public void main(String[] args){
        Thread t1 = new Thread(new InnerLockA());
        Thread t2 = new Thread(new InnerLockB());
        t1.start();
        t2.start();
    }
}
