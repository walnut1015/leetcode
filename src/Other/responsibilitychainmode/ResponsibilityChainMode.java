package Other.responsibilitychainmode;


/**
 * Created by Tanya on 2017/9/11.
 * 实现了一个java责任链模式的小例子
 */
public class ResponsibilityChainMode
{
    static public void main(String[]args)
    {
        Handler ahd = new AHandler();
        Handler bhd = new BHandler(ahd);
        Handler chd = new CHandler(bhd);
        Request arq = new ARequest();
        Request brq = new BRequest();
        Request crq = new CRequest();
        chd.action(arq);
        System.out.println("============================");
        chd.action(brq);
        System.out.println("============================");
        chd.action(crq);
        System.out.println("============================");

    }
}
