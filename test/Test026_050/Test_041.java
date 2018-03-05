package Test026_050;

import LeetCode026_050.Solution041;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tanya on 2017/8/14.
 */
public class Test_041
{
    @Test
    public void test()
    {
        Solution041 sol = new Solution041();
        int[] can = {0, 1, 2};
        System.out.print(sol.firstMissingPositive(can));
    }
}
