package LeetCode000_025;

import java.util.*;

/**
 * Created by Tanya on 2017/4/18.
 */
public class Solution015 {
//方法为先遍历数组（不要重复的数字）找出三元组的头一个数字，然后再对剩下的数字用O(n)复杂度找出另两个数字——精华部分
//避免重复三元组的方法很聪明
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i<len-2; i++)
        {
            //if(nums[i]!=nums[i+1])这样写的话会漏掉如[2,4,4,1]，sum=9这样的情况。
            if(i==0 || nums[i]!=nums[i-1])//防边界溢出。
            {
                int lo = i+1,hi = len-1, sum = 0 - nums[i];
                while(lo<hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                        //此处曾出现过数组越界
                        while (lo<len && nums[lo] == nums[lo - 1]) lo++;
                        while (hi>-1 && nums[hi] == nums[hi + 1]) hi--;
                    }
                    else  if(sum>(nums[lo]+nums[hi])) lo++;
                    else hi--;
                }
            }
            //else i++;多了一个i++一段for程序中有两个i++。。。
        }
        return res;
    }
}
