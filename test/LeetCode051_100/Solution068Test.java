package LeetCode051_100;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * class: Solution068Test
 *
 * @author 刘天雅
 * @date 2018/03/06
 */
public class Solution068Test {

    @Test
    public void fullJustify()
    {
        Solution068 sol = new Solution068();
        //String[]words = {"This", "is", "an","example", "of", "text", "justification."};
        String[]words = {"a"};
        List<String> res = sol.fullJustify(words,1);
        System.out.println(res);
    }
}