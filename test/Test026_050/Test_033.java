package Test026_050;

import LeetCode026_050.Solution033;
import org.junit.Test;

/**
 * Created by Tanya on 2017/7/6.
 */
public class Test_033 {
    @Test
    public void test()
    {
        int[]nums={4,5,6,7,0,1,2};
        Solution033 sol = new Solution033();
        System.out.println(sol.search(nums,3));
    }
}
