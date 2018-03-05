package LeetCode051_100;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/10/7.
 */
public class Solution056Test {

    @Test
    public void testMerge() throws Exception {
        Solution056 sol = new Solution056();
        int [][]input={{2,3},{5,5},{2,2},{3,4},{3,4}};//{{1,18},{2,6},{8,10},{15,18}};
        List<Interval> intervals = new LinkedList<>();
        for(int i = 0; i<input.length;i++)
            intervals.add(new Interval(input[i][0],input[i][1]));
        List<Interval> a = sol.merge(intervals);
        for(Interval b:a)
            System.out.println(b.start+"   "+b.end);
    }
}