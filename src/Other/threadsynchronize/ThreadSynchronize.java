package Other.threadsynchronize;

/**
 * class: ThreadSynchronize
 *
 * @author 刘天雅
 * @date 2018/02/22
 */
public class ThreadSynchronize implements Runnable
{
    private Bank b;
    public ThreadSynchronize(Bank b)
    {
        this.b=b;
    }
    public void run()
    {
        b.saveMoney(1);
    }
}
