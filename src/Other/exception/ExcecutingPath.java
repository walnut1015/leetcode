package Other.exception;

import java.util.ArrayList;

/**
 * class: ExcetutingPath
 *
 * @author 刘天雅
 * @date 2018/03/05
 */
public class ExcecutingPath
{
    public void devideByZero()
    {
        ArrayList<String> strs = new ArrayList<>();
        try {
            strs.add("tanya");
            int a = 1/0;
            System.out.println("OutOfBoundException抛出的后一行");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("捕捉到OutOfBoundException继续执行");
    }
}
