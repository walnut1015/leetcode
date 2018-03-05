package LeetCode000_025;

import java.util.*;

/**
 * Created by Tanya on 2017/6/11.
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 Note: The solution set must not contain duplicate quadruplets.
 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
//做得挺麻烦的，而且最后要避免不出现重复的四元组，就更麻烦了。目前只能实现不出现重复索引的四元组。
public class Solution018 {
    int target;
    int[] nums;
    ArrayList<Sum> sum = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        Set<List<Integer>> resSet = new HashSet<List<Integer>>();
        if (nums.length<4) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-3;i++)
        {
            for(int j =i+1;j<nums.length-2;j++)
            {
                int sumijleft = target - nums[i] - nums[j];
                int low = j+1;
                int high = nums.length-1;
                while(low<high)
                {
                    if(nums[low]+nums[high]==sumijleft)
                    {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[low]);
                        integers.add(nums[high]);
                        resSet.add(integers);
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high]<sumijleft)
                        low++;
                    else high--;
                }
            }
        }
        return new ArrayList<List<Integer>>(resSet);
    }

    public List<List<Integer>> fourSum2(int[] nums, int target)
    {
        Arrays.sort(nums);
        Set<List<Integer>> resSet = new HashSet<List<Integer>>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums.length<4) return res;
        this.target = target;
        this.nums=nums;
        for(int i = 0;i<nums.length;i++)
        {
            for(int j =i+1;j<nums.length;j++)
            {
                Sum curSum = new Sum();
                curSum.index1=i;
                curSum.index2=j;
                curSum.sum=nums[i]+nums[j];
                sum.add(curSum);
            }
        }
        for(int i = 0;i<nums.length;i++)
        {
            for(int j =i+1;j<nums.length;j++)
            {
                ArrayList<Sum> otherIndexes = getSumMembers(target-nums[i]-nums[j],i,j);
                for(int k=0;k<otherIndexes.size();k++) {
                    List<Integer> integers = new LinkedList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(nums[otherIndexes.get(k).index1]);
                    integers.add(nums[otherIndexes.get(k).index2]);
                    resSet.add(integers);
                }
            }
        }
        System.out.println(sum.get(0));
        return (new LinkedList<List<Integer>>(resSet));
    }

    private ArrayList<Sum> getSumMembers(int num,int index3,int index4)
    {
        ArrayList<Sum> res = new ArrayList<>();
        for(int i =0;i<sum.size();i++)
        {
            if(sum.get(i).sum==num && !isOverlap(sum.get(i),index3,index4))
                res.add(sum.get(i));
        }
        return res;
    }
    private boolean isOverlap(Sum sum, int index3, int index4)
    {
        if(sum.index1 > index3 && sum.index2 > index3 && sum.index1 > index4 && sum.index2 > index4)
            {
                return false;
            }
        return true;
    }
    class Sum{
        public int index1;
        public int index2;
        public int sum;
    }
}
