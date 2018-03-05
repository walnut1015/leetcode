package LeetCode051_100;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/9/19.
 */
public class Solution055Test {

    @Test
    public void testCanJump() throws Exception
    {
        Solution055 sol = new Solution055();
        int [] nums = {1,2,3};//{2,2,1,1,3,2,1,1,1};
        System.out.println(sol.canJump(nums));
    }
}