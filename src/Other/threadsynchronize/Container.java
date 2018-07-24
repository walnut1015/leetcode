package Other.threadsynchronize;

/**
 * @author tanya
 * @date 2018/7/14 20:16
 */
public  class Container{
    private int ele;

    public int  getEle() {
        return ele;
    }

    public void setEle(int ele) {
        this.ele = ele;
        System.out.println("当前元素值为"+ ele);
    }
    public synchronized void add(){
        int a = ele;
        ele = a+2;
        System.out.println("当前元素值为"+ ele);
        System.out.println("Thread 2");
        Thread.yield();
    }
}
