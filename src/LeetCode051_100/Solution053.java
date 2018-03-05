package LeetCode051_100;

/**
 * Created by Tanya on 2017/9/14.
 */
public class Solution053
{
    public int maxSubArray(int[] nums)
    {
        if (nums==null || nums.length==0)
            return  0;
//        int []maxSum = new int[nums.length];
//        maxSum[0] = nums[0];
//        int max = maxSum[0];
//        for (int i = 1;i<nums.length;i++)
//        {
//            if(maxSum[i-1]>0)
//                maxSum[i]=maxSum[i-1]+nums[i];
//            else maxSum[i] = nums[i];
//            max = Math.max(max,maxSum[i]);
//        }
        int max = nums[0];
        int sum = max;
        for (int i = 1;i<nums.length;i++)
        {
            sum = Math.max(nums[i],sum+nums[i]);
            max = Math.max(max,sum);
        }
        return max;
    }
}
