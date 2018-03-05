package Other.responsibilitychainmode;

/**
 * Created by Tanya on 2017/9/11.
 */
public class CHandler implements Handler
{
    Handler h ;
    public CHandler(Handler h)
    {
        this.h = h;
    }
    public void action(Request rq)
    {
        if(rq instanceof CRequest)
        {
            System.out.println("处理C请求");
        }
        else h.action(rq);
    }
}