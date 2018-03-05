package LeetCode051_100;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/10/17.
 */
public class Solution064Test {

    @Test
    public void testMinPathSum() throws Exception
    {
        Solution064 sol = new Solution064();
        //int[][] ints = {{1,1,1},{1,2,0},{1,1,1}};
        int[][] ints = {{3},{2}};
        //int[][] ints = {{3}};
        System.out.println(sol.minPathSum(ints));
    }
}