package Other;

import Other.responsibilitychainmode.MeanLily;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tanya on 2017/8/31.
 */
public class MeanLilyTest {

    @Test
    public void testOrderFood() throws Exception
    {
        MeanLily ml = new MeanLily();
        List<List<Integer>> input= new LinkedList<>();
        List<Integer> info = new LinkedList<>();
        info.add(10);
        info.add(2);
        info.add(3);
        input.add(info);
        List<Integer> price1 = new LinkedList<>();
        price1.add(5);
        List<Integer> price2 = new LinkedList<>();
        price2.add(3);
        List<Integer> price3 = new LinkedList<>();
        price3.add(7);
        input.add(price1);
        input.add(price2);
        input.add(price3);
        System.out.println(ml.orderFood(input));
    }
}