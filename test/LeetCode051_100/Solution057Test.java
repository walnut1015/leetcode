package LeetCode051_100;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/10/7.
 */
public class Solution057Test {

    @Test
    public void testInsert() throws Exception {
        Solution057 sol = new Solution057();
        int [][]input={{1,4}};//{{1,2},{3,5},{6,7},{8,10},{12,16}};//{{1,18},{2,6},{8,10},{15,18}};
        List<Interval> intervals = new LinkedList<>();
        for(int i = 0; i<input.length;i++)
            intervals.add(new Interval(input[i][0],input[i][1]));
        List<Interval> a = sol.insert(intervals,new Interval(4,9));
        for(Interval b:a)
            System.out.println(b.start+"   "+b.end);
    }
}