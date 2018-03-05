package Test000_025;

import LeetCode000_025.Solution022;

import java.util.List;

/**
 * Created by Tanya on 2017/6/15.
 */
public class Test_022
{
    @org.junit.Test
    public void test()
    {
        Solution022 sol = new Solution022();
        List<String> res = sol.generateParenthesis(3);
        for(String e:res)
        {
            System.out.println(e);
        }
    }
}
