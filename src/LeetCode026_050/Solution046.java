package LeetCode026_050;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tanya on 2017/8/19.
 * 运用的数据结构：队列。将linkedlist作为队列来使用。
 * add(index, element) set(index, element)作用是不一样的哟。
 * peek--getFirst, addFirst,removeFirst--poll--pop,
 *        getLast, addLast,removeLast,
 */
public class Solution046
{
    public List<List<Integer>> permute(int[] nums)
    {
        if(nums.length==0 || nums==null)
            return null;
        int len = nums.length;
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> first = new LinkedList<>();
        first.add(nums[0]);
        res.add(first);
        for(int i = 1;i< nums.length;i++)
        {
            place(nums,i,res);
        }
        return res;
    }
    private void place(int[]nums, int pos,LinkedList<List<Integer>> lists)
    {
        //pos是这次要插入的数字在nums中的位置。
        while (lists.peek().size()<pos+1)
        {
            List<Integer> list = lists.getFirst();
            lists.removeFirst();
            for(int i = 0;i<=pos;i++)
            {
                List<Integer> tempList = new LinkedList<>(list);
                tempList.add(i,nums[pos]);
                lists.addLast(tempList);
            }
        }
    }
}
