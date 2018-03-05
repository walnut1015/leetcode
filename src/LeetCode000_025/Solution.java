package LeetCode000_025;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        //无法避免重复
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        int end = Math.abs(nums[0]+nums[1])>Math.abs(nums[nums.length-1]+nums[nums.length-2])?nums[0]+nums[1]:nums[nums.length-1]+nums[nums.length-2];
        for(int i = end;i<= target/2;i++)
        {

        }
        return res;

    }
}