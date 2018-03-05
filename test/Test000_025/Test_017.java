/**
 * Created by Tanya on 2017/6/10.
 */
import org.junit.Test;

import java.util.List;

public class Test_017
{
    @Test
    public void test()
    {
        LeetCode000_025.Solution017 sol = new LeetCode000_025.Solution017();
        List<String> res = sol.letterCombinations("717");
        int len = res.size();
        for(int i =0;i<len;i++)
        {
            System.out.println(res.get(i));
        }
    }
}
