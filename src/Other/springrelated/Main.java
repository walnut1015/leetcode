package Other.springrelated;

/**
 * @author tanya
 * @date 2018/9/10 22:13
 */
public class Main {
    public static void main(String[] args) {
        Object clock = new AlarmClock();
        try {
            Clock proxy = (Clock)MyProxyFactory.getProxy(clock);
            proxy.showTime();
            Class<?>[] classes = proxy.getClass().getInterfaces();
            for(Class<?> clazz:classes){
                System.out.println(clazz.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
