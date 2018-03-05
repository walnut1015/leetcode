package LeetCode026_050;

/**
 * Created by Tanya on 2017/8/15.
 */
public class Solution042
{
    public int trap(int[] height)
    {
        if(height.length<3)
            return 0;
        int len = height.length;
        int vol = 0;
        int []leftHighest = new int[len];
        int []rightHighest = new int[len];
        leftHighest[0] = height[0];
        rightHighest[len-1] = height[len-1];
        for(int i = 1;i<len;i++)
        {
            leftHighest[i] = Math.max(height[i],leftHighest[i-1]);
            rightHighest[len-1-i] = Math.max(height[len-i-1], rightHighest[len-i]);
        }
        for(int i = 0;i<len;i++)
        {
            //这一个可能性根本就不会发生啊 啊啊啊啊啊！
//            if(rightHighest[i]<height[i]||leftHighest[i]<height[i])
//                continue;
            vol+=Math.min(rightHighest[i],leftHighest[i])-height[i];
        }

        return vol;
    }
}
