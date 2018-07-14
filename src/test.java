import java.util.Scanner;

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
    public static void main(String[] args){
        MyThread t = new MyThread();
        t.start();
        num = 3;
        ready = true;
    }
}
