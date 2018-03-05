package LeetCode026_050;

/**
 * Created by Tanya on 2017/6/19.
 */
public class Solution027
{
    public int removeElement(int[] nums, int val)
    {
        int valNum = 0;
        int intervLen = 0;
        for(int i = 0;i<nums.length;i++)
        {
            int j = i;
            while(i<nums.length && nums[i]==val) i++; //以一个不为 nums[i] != val 或者 i = lengh，nums[nums.length-1]等于val位置结束。
            if(j!=i)// 则nums[j]==val,需要向前平移
            {
                intervLen +=(i-j);
            }
            if(i<nums.length)
            {
                nums[i-intervLen] = nums[i];
            }
        }
        return nums.length - intervLen;
    }
}
