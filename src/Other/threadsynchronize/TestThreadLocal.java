package Other.threadsynchronize;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author tanya
 * @date 2018/7/10 23:09
 */
public class TestThreadLocal
{
    private static class Value{
        public int value;
    }
    private static ThreadLocal<Value> value = new ThreadLocal<Value>(){
        @Override
        public Value initialValue(){
            Value v = new Value();
            v.value = 5;
            return v;
        }
    };
    public static Value getValue(){
        return value.get();
    }
    public static void setValue(Value v){
        value.set(v);
    }

    public static class MyThread implements Runnable{
        private String name = null;
        private int valuel;
        @Override
        public void run(){
            while (true) {
                Value v = new Value();
                v.value = valuel;
                System.out.println(name+"存入-->"+ valuel);
                Thread.yield();
                value.set(v);
                System.out.println(name+"取出-->"+value.get().value);
                Thread.yield();
            }
        }
        public void setName(String name){
            this.name = name;
        }

        public void setValue(int value){
            this.valuel = value;

        }
    }
    public static void main(String[] ars)
    {
        MyThread t1 = new MyThread();
        t1.setName("t1");
        t1.setValue(10);
        MyThread t2 = new MyThread();
        t2.setName("t2");
        t2.setValue(0);

        new Thread(t1).start();
        new Thread(t2).start();
    }
}
