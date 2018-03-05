package Other.threadsynchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * class: ThreadCooperate
 *
 * @author 刘天雅
 * @date 2018/02/26
 */
public class ThreadCooperation
{
    private static Bank bank = new Bank();
    private static class DepositTask implements Runnable
    {
        public void run()
        {

            try
            {
                while (true)
                {
                    bank.deposit((int) (Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e)
            {
                    e.printStackTrace();
            }
        }
    }
    private static class WithdrawTask implements Runnable
    {
        public void run()
        {
            while (true)
            {
                bank.withdraw((int) (Math.random() * 10) + 1);
                //Thread.sleep(1000);
            }
        }
    }
    public static void main(String[] args)
    {
/*        Thread t1 = new Thread(new WithdrawTask());
        Thread t2 = new Thread(new DepositTask());
        t1.start();
        t2.start();*/
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new WithdrawTask());
        exe.execute(new DepositTask());
    }
}
