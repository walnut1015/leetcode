package LeetCode026_050;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/9/10.
 */
public class Solution048Test {

    @Test
    public void testRotate() throws Exception {
        int n = 4;
        int[][] matrix = new int[n][n];
        for(int i=0; i<n*n;i++)
        {
            matrix[i/n][i%n] = i;
        }
        Solution048 sol = new Solution048();
        sol.rotate(matrix);
    }
}