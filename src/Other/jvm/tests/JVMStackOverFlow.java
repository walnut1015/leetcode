package Other.jvm.tests;

/**
 * class: JVMStackOverFlow
 *
 * @author 刘天雅
 * @date 2018/02/25
 */
public class JVMStackOverFlow
{
    private int stackLen = 1;
    public void stackLeak()
    {
        System.out.println(stackLen);
        stackLen++;
        stackLeak();
    }
    public static void main(String[] args)throws Throwable
    {
        JVMStackOverFlow jsof = new JVMStackOverFlow();
        try {
            jsof.stackLeak();
        } catch (Exception e) {
            System.out.println(jsof.stackLen);
        } finally {
        }
    }
}
