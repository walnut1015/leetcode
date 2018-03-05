package LeetCode026_050;

/**
 * Created by Tanya on 2017/6/18.
 */
//
public class Solution026
{
    public int removeDuplicates(int[] nums)
    {
        if(nums.length<2) return nums.length;
        int intervLen = 0;
        for(int i = 0; i<nums.length-1;i++)
        {
            int j = i;
            while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
            intervLen += (i-j); //最后两个数字不相等的话,intervLen增量为0.
            int low = i,high;
            while(i<nums.length-1 && nums[i]!=nums[i+1]) i++;//在下一串重复的数字之前，往前平移。
            i--;//所以如果上一行的while循环没有进入的话 high = low -1,最后一个数字
                // 不会被平移，但是IntervLen对于最后一个数字来说是正确的。
            high = i;
            for( int k = low;k<=high;k++)  nums[k - intervLen] = nums[k];
        }
        nums[nums.length-1- intervLen] = nums[nums.length-1];//最后一个数字在for循环中失去了平移的机会。
        return nums.length - intervLen;
    }
}
