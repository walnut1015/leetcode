package LeetCode026_050;

import java.util.Arrays;

/**
 * Created by Tanya on 2017/7/2.
 */
//找出从右往左的第一个升序对，。
//
public class Solution031
{
    public void nextPermutation(int[] nums)
    {
        if(nums.length<2)
            return;
        int i = nums.length-1;
        for(;i>0;i--)
        {
            if(nums[i]>nums[i-1])
                break;
        }
        if(i==0)//说明整个序列已经是排列组合中的最大值
        {
            Arrays.sort(nums);
            return;
        }
        //将i+1直到末尾的数组全部翻转过来。
        for(int j = i+1;j<=(nums.length + i) / 2;j++)
        {
            swap(nums, j, nums.length+i-j);
        }
        //找到最小的比nums[i-1]大的数字。
        int smallestAfteri = i;
        for(int j = i+1;j < nums.length;j++)
            if(nums[j] < nums[smallestAfteri] && nums[j] > nums[i-1]) //第二个判断忘了写
                smallestAfteri = j;
        //交换之后，i+1到数组末尾的数字应当一直有序，但是i处的数字未知，应当再插进有序子数组中去。
        swap(nums,i-1,smallestAfteri);
        int numi = nums[i];
        int j = i+1;
        for(;j<nums.length && nums[j]<numi;j++)
            nums[j-1] = nums[j];
        nums[j-1] = numi;
    }
    private void swap(int []nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation1(int[] nums)
    {
        int i = nums.length-1;
        for(;i>0;i--)
        {
            if(nums[i]>nums[i-1])
                break;
        }
        if(i==0)//说明整个序列已经是排列组合中的最大值
        {
            Arrays.sort(nums);
            return;
        }
        int smallestAfteri = i;
        for(int j = i+1;j < nums.length;j++)
            if(nums[smallestAfteri] > nums[j] && nums[j]>nums[i-1]) //第二个判断忘了写
                smallestAfteri = j;
        int temp = nums[i-1];
        nums[i-1] = nums[smallestAfteri];
        nums[smallestAfteri] = temp;
        Arrays.sort(nums, i, nums.length);
    }
}
