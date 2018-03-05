package Other.threadsynchronize;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * class: ThreadSynchronizeTest
 *
 * @author 刘天雅
 * @date 2018/02/22
 */
public class ThreadSynchronizeTest {

    @Test
    public void testRun() throws Exception {
        ExecutorService exe = Executors.newCachedThreadPool();
        Bank b = new Bank();
        for(int i = 0;i<100;i++)
        {
            exe.execute(new ThreadSynchronize(b));
        }
        exe.shutdown();
        while(!exe.isTerminated()){

        }
        //System.out.println(b.money);
    }
}