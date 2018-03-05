package LeetCode051_100;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/9/14.
 */
public class Solution053Test {

    @Test
    public void testMaxSubArray() throws Exception {
        Solution053 sol = new Solution053();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sol.maxSubArray(nums));
    }
}