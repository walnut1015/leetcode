package LeetCode051_100;

import java.util.*;

/**
 * Created by Tanya on 2017/10/6.
 */

public class Solution056
{
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals ==null || intervals.size()==0)
            return new LinkedList<Interval>();
        Map<Integer,Integer> map = new HashMap();
        int []starts = new int[intervals.size()];
        int i =0;
        for(Interval ele: intervals)
        {
            if(map.get(ele.start)==null)
                map.put(ele.start,ele.end);
            else map.put(ele.start,Math.max(map.get(ele.start),ele.end));
            starts[i++] = ele.start;
        }
        Arrays.sort(starts);
        for(int j = 1;j<starts.length;j++)
        {
            if(starts[j]==starts[j-1])
                continue;
            int priorStart = starts[j-1];
            int priorEnd = map.get(priorStart);
            int curStart = starts[j];
            int curEnd = map.get(curStart);
            if(curStart<=priorEnd)
            {
                map.put(priorStart,Math.max(priorEnd,curEnd));
                for(int k = j;k<starts.length && starts[k]==curStart;k++)
                    starts[k]=starts[j-1];
                map.remove(curStart);
            }

        }
        List<Interval> res = new LinkedList<>();
        for(Integer start: map.keySet())
            res.add(new Interval(start,map.get(start)));
        return res;
    }
}
