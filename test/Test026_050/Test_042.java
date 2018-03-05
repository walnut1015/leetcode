package Test026_050;

import LeetCode026_050.Solution042;
import org.junit.Test;

/**
 * Created by Tanya on 2017/8/15.
 */
public class Test_042 {
    @Test
    public void test()
    {
        Solution042 sol = new Solution042();
        int[] can = {0,1,2,3};
        System.out.println(sol.trap(can));
    }
}
