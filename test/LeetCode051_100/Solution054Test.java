package LeetCode051_100;

import LeetCode000_025.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/9/14.
 */
public class Solution054Test {

    @Test
    public void testSpiralOrder() throws Exception {
        Solution054 sol = new Solution054();
        int[][] matrix = {
                {1, 2, 3},
               {4, 5, 6},
//                {7, 8, 9}
        };
        System.out.println(sol.spiralOrder(matrix));
    }
}