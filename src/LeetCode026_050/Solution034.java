package LeetCode026_050;

/**
 * Created by Tanya on 2017/7/7.
 */
//第一个版本是先找出target，然后将数组分为两段，前一段中找上界，后一段中找下界
// 参考别人的代码之后发现不用找出target，直接。

public class Solution034
{
    public int[] searchRange(int[] nums, int target)
    {
    int []res=new int[2];
    res[0] = -1;
    res[1] = -1;
    if(nums.length==0 || target<nums[0] || target>nums[nums.length-1])
        return res;
    int lo = 0,hi = nums.length-1,mid = (lo+hi)/2;
    while(lo<hi)
    {
        mid = (lo+hi)/2;
        if(nums[mid]==target)
        {
            hi = mid;
            if(nums[hi]!=target)
                hi--;
        }
        else if(nums[mid]<target)
        {
            lo = mid+1;
        }
        else
            hi = mid-1;
    }
    if(nums[lo]!=target)
        return res;
    res[0] = lo;
    lo = res[0];
    hi = nums.length-1;
    while(nums[lo]!=nums[hi])
    {
        mid = (lo+hi)/2;
        if(nums[mid]==target)
        {
            lo = mid;
            if(nums[hi]!=target)
                hi--;
        }

        else
        {
            hi = mid-1;
        }
    }
    res[1]=hi;
    return res;
}
    public int[] searchRange1(int[] nums, int target)
    {
        int []res=new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums.length==0 || target<nums[0] || target>nums[nums.length-1])
            return res;
        int lo = 0,hi = nums.length-1,mid = (lo+hi)/2;;
        int pos=-1;
        while(lo<=hi)
        {
            mid = (lo+hi)/2;
            if(target == nums[mid])
            {
                pos = mid;
                break;
            }
            else if(target<nums[mid])
                hi = mid-1;
            else
                lo = mid+1;
        }
        if(lo>hi)
            return res;
        lo = 0;
        hi = pos;
        while(nums[lo]!=nums[hi])
        {
            mid = (lo+hi)/2;
            if(nums[mid]==target)
            {
                hi = mid;
                if(nums[lo]!=target)
                    lo++;
            }
            else
            {
                lo = mid+1;
            }
        }
        res[0] = lo;
        lo = pos;
        hi = nums.length-1;
        while(nums[lo]!=nums[hi])
        {
            mid = (lo+hi)/2;
            if(nums[mid]==target)
            {
                lo = mid;
                if(nums[hi]!=target)
                    hi--;
            }

            else
            {
                hi = mid-1;
            }
        }
        res[1]=hi;
        return res;
    }
}
