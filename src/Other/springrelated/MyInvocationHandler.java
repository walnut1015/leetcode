package Other.springrelated;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author tanya
 * @date 2018/9/10 21:51
 */
public class MyInvocationHandler  implements InvocationHandler{
    //需要被代理的对象
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 只要调用到动态代理对象的方法，即method??，就会调用该invoke方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Exception
     */
    @Override
    public Object invoke(Object proxy, Method method,Object[] args)throws Exception{
        ClockTxUtils tx = new ClockTxUtils();
        tx.beforeAlarm();
        //不知道下一句在做什么
        //对target对象调用 method，以args作为method方法的参数。
        Object res = method.invoke(target, args);
        //返回类型为void的方法判断，是和Void.TYPE相等的，而和Void.class却不相等
        if(!(method.getName().equals("showTime") && method.getReturnType().equals(Void.TYPE))) {
            tx.afterAlarm1();
        }
        return res;

    }
}
