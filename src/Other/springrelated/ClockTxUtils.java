package Other.springrelated;

/**
 * @author tanya
 * @date 2018/9/10 21:58
 */
public class ClockTxUtils {
    public void beforeAlarm(){
        System.out.println("起床时间到了！");
    }
    public void afterAlarm1(){
        System.out.println("十分钟后再次响起");
    }
    public void afterAlarm2(){
        System.out.println("退出打扰");
    }
}
