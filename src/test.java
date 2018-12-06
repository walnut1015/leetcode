import sun.misc.Unsafe;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class test
{

    static  int num = 0;
    static  boolean ready = false;
    static private class MyThread extends Thread{
        @Override
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println(num);
        }
    }
    private static class MyValue{
        private String name = "init";

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args){
       ThreadLocal<MyValue> threadLocal = new ThreadLocal<>();
       MyValue v = new MyValue();
       threadLocal.set(v);
       v.setName("s");
        System.out.println(threadLocal.get().getName());
        Unsafe u;
        ReentrantLock r;

    }
}
