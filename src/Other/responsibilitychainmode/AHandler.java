package Other.responsibilitychainmode;

/**
 * Created by Tanya on 2017/9/11.
 */

public class AHandler implements Handler
{
    public void action(Request rq)
    {
        if(rq instanceof ARequest)
        {
            System.out.println("处理A请求");
        }
    }
}
