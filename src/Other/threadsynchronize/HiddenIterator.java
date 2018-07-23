package Other.threadsynchronize;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author tanya
 * @date 2018/7/15 16:22
 */
public class HiddenIterator
{
    Set<Integer> mySet = new HashSet<>();
    private void privateFatherFunc(){
        System.out.println("I'm father");
    }
    public void testFatherFunc(){
        privateFatherFunc();
    }
    public void addTenThings(){
        Random random = new Random();
        for(int i = 0; i<10;i++){
            mySet.add(random.nextInt());
        }
        System.out.println("插入了十个数字："+mySet);
    }
    static class Task implements Runnable{
        public HiddenIterator hi;
        @Override
        public void run(){
            while (true) {
                hi.addTenThings();
            }
        }
    }
    public static void main(String[] args){
        HiddenIterator hi = new HiddenIterator();
        Task t1 = new Task();
        Task t2 = new Task();
        t1.hi = hi;
        t2.hi = hi;
        new Thread(t1).start();
        new Thread(t2).start();
        //HiddenIteraotrSon hi = new HiddenIteraotrSon();

    }
}
