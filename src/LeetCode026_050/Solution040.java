package LeetCode026_050;

import java.util.*;

/**
 * Created by Tanya on 2017/7/14.
 */
public class Solution040
{
    int []candidates;
    Set<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        res = new HashSet<>();
        this.candidates = candidates;
        Arrays.sort(candidates);
        for(int i = 0;i <candidates.length;i++)
        {
            if(candidates[i]>target)
                break;
            List<Integer> list= new ArrayList<>();
            list.add(candidates[i]);
            getCombinations(target-candidates[i], i+1, list);
        }
        return new ArrayList<>(res);
    }
    //进入该函数之前先排除candidates[curIndex]>target的情况
    //上次操作到了curIndex位置的元素。
    private void getCombinations(int target, int curIndex, List<Integer> list)
    {
        if(target == 0)
            res.add(new ArrayList<Integer>(list));
        for(;curIndex<candidates.length;curIndex++)
        {
            if(candidates[curIndex]<= target)
            {
                list.add(candidates[curIndex]);
                getCombinations(target-candidates[curIndex], curIndex+1, list);
                list.remove(list.size()-1);
            }
            else
                break;
        }
    }
}
