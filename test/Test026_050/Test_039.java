package Test026_050;

import LeetCode026_050.Solution038;
import LeetCode026_050.Solution039;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tanya on 2017/8/13.
 */
public class Test_039 {

    @Test
    public void test()
    {
        Solution039 sol = new Solution039();
        //System.out.println(sol.countAndSay2(50));
        int[] can = {2,3,5,7};
        List<List<Integer>> res = sol.combinationSum(can, 7);
        System.out.print("");
    }
}
