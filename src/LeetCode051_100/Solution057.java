package LeetCode051_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tanya on 2017/10/7.
 */
public class Solution057
{
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //特殊情况
        if(newInterval==null)
            return intervals;
        List<Interval> res = new  LinkedList<>();
        if(intervals==null || intervals.size()==0)
        {
            res.add(newInterval);
            return res;
        }
//        if(intervals.size()==1)
//        {
//            if(Math.min(intervals.get(0).end,newInterval.end)>=Math.max(intervals.get(0).start,newInterval.start))
//                res.add(new Interval(Math.min(intervals.get(0).start,newInterval.start),Math.max(intervals.get(0).end,newInterval.end)));
//            else
//            {
//                intervals.add(newInterval);
//                return intervals;
//            }
//            return res;
//        }


        int []starts = new int[intervals.size()+1];
        int []ends = new int[intervals.size()+1];
        int k =0;
        intervals.add(newInterval);
        for(Interval interval: intervals)
        {

            starts[k]=interval.start;
            ends[k++] = interval.end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i = 0;
        for(int j = 1;j<ends.length;j++)
        {
            if(starts[j]>ends[j-1])
            {
                res.add(new Interval(starts[i],ends[j-1]));
                i = j;
            }
        }
        if(starts[ends.length-1]>ends[ends.length-2])
            res.add(new Interval(starts[ends.length-1],ends[ends.length-1]));
        else
            res.add(new Interval(starts[i],ends[ends.length-1]));
        return res;
    }
}
