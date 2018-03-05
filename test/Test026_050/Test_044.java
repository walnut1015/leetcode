package Test026_050;

import LeetCode026_050.Solution044;
import org.junit.Test;

/**
 * Created by Tanya on 2017/8/17.
 */
public class Test_044 {
    @Test
    public void test()
    {
        Solution044 sol = new Solution044();
        int[] can = {0, 1, 2};
        String s = "aaaa";
        String p =         "***a"
;

        System.out.println(sol.isMatch(s,p));
    }
}
