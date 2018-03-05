package Other.threadsynchronize;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class: Bank
 *
 * @author 刘天雅
 * @date 2018/02/22
 */
public class Bank
{
    private int money = 0;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    public synchronized void saveMoney(int num)
    {
        int a = money + num;
        try {
            Thread.sleep(1);
            money = a;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deposit(int num)
    {
        lock.lock();
        try {
            money+=num;
            notEmpty.signalAll();
            System.out.println("存入钱："+num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void withdraw(int num)
    {
        lock.lock();
        try {
            while(money<num)
            {
                System.out.println("等待存钱ing。。。");
                notEmpty.await();
            }
            money-=num;
            System.out.println("取出钱："+num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
