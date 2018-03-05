package LeetCode051_100;

/**
 * Created by Tanya on 2017/9/14.
 * Jump Game I
 * 还是用
 */
public class Solution055
{

    public boolean canJump(int[] nums)
    {
        if(nums == null || nums.length ==0)
            return false;
        if(nums.length == 1 && nums[0]==0)
            return true;
        int farthest = nums[0];
        for(int i =0;i<nums.length && i<=farthest;i++)
        {
            farthest = Math.max(farthest,nums[i]+i);
        }
        return farthest<nums.length-1?false:true;
    }
    public boolean canJump1(int[] nums)
    {
        if(nums == null || nums.length ==0)
            return false;
        if(nums.length == 1 && nums[0]==0)
            return true;
        int jumFarthest = 0;
        int []shortestPath = new int[nums.length];
        int curFixed = 0;
        shortestPath[0] = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(i == curFixed && nums[i]==0)
                if(i!=nums.length )
                return false;
            for(int k = i + nums[i];k>curFixed && k<nums.length;k--)
                shortestPath[k] = shortestPath[i] +1;
            curFixed = Math.max(i+nums[i],curFixed);
        }
        return true;
    }
}
