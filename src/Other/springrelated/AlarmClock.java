package Other.springrelated;

import java.util.Date;

/**
 * @author tanya
 * @date 2018/9/10 21:44
 */
public class AlarmClock implements Clock{
    @Override
    public void alarm(){
        System.out.println("woo woo woo woo");
    }

    @Override
    public void showTime() {
        Date a = new Date();
        System.out.println("现在的时间是"+a);
    }
}
