package LeetCode026_050;

/**
 * Created by Tanya on 2017/8/14.
 */
public class Solution041 {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0)
            return 1;
        if(nums.length==1)
            if(nums[0]!=1)
                return 1;
            else return 2;

        int res = 0,max = 0;
        for(int i = 0;i<nums.length;)
        {
            if(nums[i]==i+1)
            {
                if(nums[i]>max)
                    max = nums[i];
                i++;
                continue;
            }
            if(nums[i]>0 && nums[i]<=nums.length)
            {
                int temp1 = nums[nums[i]-1];
                int temp2 = nums[i];
                if(nums[i]>max)
                    max = nums[i];
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                //重复的正数值用-1替代。
                if(temp1 == temp2)
                    nums[i] = -1;
            }
            if(nums[i]>0 && nums[i]<=nums.length)
                continue;
            i++;
        }
        if(nums[0] != 1)
            return 1;
        for(int i = 1;i< max;i++)
        {
            if(nums[i] != nums[i-1]+1)
            {
                return i+1;
            }
        }
        //以防123...max的情况。
        return max+1;
    }
}
