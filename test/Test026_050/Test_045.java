package Test026_050;

import LeetCode026_050.Solution045;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Tanya on 2017/8/17.
 */
public class Test_045 {
    @Test
    public void test()
    {
        Solution045 sol = new Solution045();
        //int []can = {2,3,1,1,4};
        //int[] can = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};//               ;
        int[] can = new int[25001];
        Arrays.fill(can,1);
        //for(int i=0;i<=25000;i++)
        //    can[i] = 25000-i;
        System.out.println(sol.jump(can));
    }
}
