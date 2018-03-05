package LeetCode026_050;

/**
 * Created by Tanya on 2017/7/4.
 */
//直接挨个比较来做。发现有的人的解法中采用二分查找法寻找到最小的元
// 素的索引，然后再用二分查找来着元素。在这种数组中用二分查找让人印象深刻。
public class Solution033
{
    public int search(int[] nums, int target)
    {
        if(nums.length==0)
            return -1;
        if(nums.length==1)
            return target==nums[0]?0:-1;
        if(target<nums[0])
        {
            int i;
            for(i = nums.length-1;i>0 && nums[i-1]<nums[i];i--)
            {
                if(nums[i]==target)
                    return i;
                else if(target>nums[i])
                    break;
            }
            if(nums[i]==target) return i;
        }
        else
        {
            int j;
            for(j=0;j<nums.length-1 && nums[j]<nums[j+1];j++)
            {
                if(nums[j]==target)
                    return j;
                else if(target<nums[j])
                    break;
            }
            if(nums[j]==target)
                return j;
        }
        return -1;
    }
}
