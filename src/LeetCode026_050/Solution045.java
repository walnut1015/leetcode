package LeetCode026_050;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tanya on 2017/8/17.
 */

public class Solution045 {

    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        List<Integer> knownNodeSet = new LinkedList<>();
        //knownNodeSet.add(0);
        int []distance = new int[nums.length];
        //int[][] distance = new int[nums.length][nums.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int stepi = nums[0];
        for (int j = 1; j < nums.length && j<= stepi; j++)
        {
            {
                distance[j] = 1;
                knownNodeSet.add(j);
            }
        }
        distance[0] = 0;
        int count =0;
        while (knownNodeSet.size()!=0)
        {
            int[] curNodes = new int[knownNodeSet.size()];
            int i = 0;
            int farthest = 0;
            for (int a : knownNodeSet)
            {
                curNodes[i++] = a;
                farthest = Math.max(farthest,a);
            }
            knownNodeSet.clear();
            for (int k =0;k < i;k++)
            {
                int a = curNodes[k];
                for (int j = farthest + 1;j<nums.length && j - a <= nums[a]; j++)
                {
                    if (distance[a] + 1 < distance[j])
                    {
                        distance[j] = distance[a] + 1;
                        knownNodeSet.add(j);
                    }
                }
            }
        }
        return distance[nums.length-1];
    }
}


//    public int jump(int[] nums) {
//        if(nums.length<=1)
//            return 0;
//        return reach(nums.length-1,nums);
//    }
//    private int reach(int n,int[] nums)
//    {
//        if(n==0)
//            return 0;
//        if(nums[n]==0)
//            return Integer.MAX_VALUE;
//        int min=Integer.MAX_VALUE;
//        for(int i = 0;i<n;i++)
//            if(nums[i] >= n-i)
//                min = Math.min(min, reach(i,nums)+1);
//        return min;
//    }

