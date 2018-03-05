package Test400_450;

import LeetCode400_450.Solution407;
import org.junit.Test;

/**
 * Created by Tanya on 2017/8/15.
 */
public class Test_407
{
    @Test
    public void test()
    {
        Solution407 sol = new Solution407();
        //int[][] can = {0, 1, 2};
        int [][]a= {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
            };
        int [][]b = {
                {12,13,1,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}};
        System.out.println(sol.trapRainWater(b));
    }
}
