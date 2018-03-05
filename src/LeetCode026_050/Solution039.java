package LeetCode026_050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tanya on 2017/7/14.
 */
//一开始把这道题和2sum,3sum,4sum混淆，觉得很复杂，直到许鸿翔给我说了背包的解法。
public class Solution039
{
    int []candidates;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        res = new ArrayList<>();
        this.candidates = candidates;
        Arrays.sort(candidates);
        for(int i = 0;i <candidates.length;i++)
        {
            if(candidates[i]>target)
                break;
            List<Integer> list= new ArrayList<>();
            list.add(candidates[i]);
            getCombinations(target-candidates[i], i, list);
        }
        return res;
    }
    //进入该函数之前先排除candidates[curIndex]>target的情况
    //上次操作到了curIndex位置的元素。
    private void getCombinations(int target, int curIndex, List<Integer> list)
    {
        if(target == 0)
            res.add(new ArrayList<Integer>(list));
        if(curIndex >= candidates.length || candidates[curIndex]>target)
            return;
        //list.add(candidates[curIndex]);
        for(;curIndex<candidates.length;curIndex++)
        {
            if(candidates[curIndex]<= target)
            {
                //参考别人的更快的代码，发现多了一个对list的重复利用,修改之后挽救了2分钟的时间
//                List<Integer> list2 = new ArrayList<>(list);
//                list2.add(candidates[curIndex]);
//                getCombinations(target-candidates[curIndex], curIndex, list2);
                list.add(candidates[curIndex]);
                getCombinations(target-candidates[curIndex], curIndex, list);
                list.remove(list.size()-1);
            }
            else
                break;
        }
    }
}
