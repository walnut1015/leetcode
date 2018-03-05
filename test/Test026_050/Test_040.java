package Test026_050;

import LeetCode026_050.Solution040;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tanya on 2017/8/13.
 */
public class Test_040 {
    @Test
    public void test()
    {
        Solution040 sol = new Solution040();
        //System.out.println(sol.countAndSay2(50));
        int[] can = {10,1,2,7,6,1,5};
        List<List<Integer>> res = sol.combinationSum(can, 8);
        System.out.print("");
    }
}
