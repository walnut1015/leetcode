package LeetCode026_050;

/**
 * Created by Tanya on 2017/7/8.
 */
public class Solution035
{
    public int searchInsert(int[] nums, int target)
    {
        int lo = 0, hi = nums.length-1,mid;
        while(lo<hi)
        {
            mid = (lo+hi)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]<target)
            {
                lo = mid+1;
            }
            else
                hi = mid-1;
        }
        return nums[lo]>=target?lo:lo+1;
    }
}
