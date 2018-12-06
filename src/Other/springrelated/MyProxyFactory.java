package Other.springrelated;

import java.lang.reflect.Proxy;

/**
 * @author tanya
 * @date 2018/9/10 22:09
 */
public class MyProxyFactory {
    public static Object getProxy(Object target)throws Exception{
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
    }
}
