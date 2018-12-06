package Other.jvm.tests;

import java.util.concurrent.*;

/**
 * @author tanya
 * @date 2018/7/30 20:34
 */
public class GC {
    JVMStackOverFlow jof = new JVMStackOverFlow();

    public void testGC(){

        System.gc();
    }
    private static class task implements Runnable{
        @Override
        public void run(){
            System.out.println("执行任务");
        }
    }
    static public void main(String[] args){
        GC gc = new GC();
        gc.testGC();
        ExecutorService ex = Executors.newFixedThreadPool(5);
        FutureTask<Integer> f = new FutureTask<Integer>(new task(), 5);
        Thread t2 = new Thread(f);
        t2.start();
        try {
            System.out.println(f.isCancelled());
            System.out.println(f.get());
            f.cancel(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable t = e;
            if(t instanceof Error){
                System.out.println("出错");
                e.printStackTrace();
            }
            else if(t instanceof RuntimeException) {
                System.out.println("运行时异常");
                t.printStackTrace();
            }
            else {
                System.out.println("待检查异常");
                e.printStackTrace();
            }
        }
    }
}
