package Test026_050;

import LeetCode026_050.Solution027;
import org.junit.Test;

/**
 * Created by Tanya on 2017/6/19.
 */
public class Test_027
{
    @Test
    public void test()
    {
        Solution027 sol = new Solution027();
        int []nums = {1,9,9,2,3,2,2,5};
        int newLen = sol.removeElement(nums,2);
        System.out.println();
    }
}
