package Other.responsibilitychainmode;

/**
 * Created by Tanya on 2017/9/11.
 */
public class BHandler implements Handler
{
    Handler h ;
    public BHandler(Handler h)
    {
        this.h = h;
    }
    public void action(Request rq)
    {
        if(rq instanceof BRequest)
        {
            System.out.println("处理B请求");
        }
        else h.action(rq);
    }
}