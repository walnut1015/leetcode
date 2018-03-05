package LeetCode051_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tanya on 2017/10/9.
 */
public class Solution060
{
    public String getPermutation(int n, int k)
    {
        if(n==1)
            return "1";
        List<Integer> nums = new ArrayList<>();
        int divide = 1;
        for(int i = 1;i<=n;i++)
        {
            nums.add(i);
            divide *= i;
        }
        //Collections.sort(ints);
        StringBuilder sb = new StringBuilder();

        getNextInt(k, divide, nums, sb);
        return sb.toString();

    }
    /**
     * @param divide 对于n=4来说，divide 在每次调用时，依次为24,6,2...
     */
    private void getNextInt(int k ,int divide, List<Integer> nums, StringBuilder sb)
    {
        if(divide ==2)
        {
            if(k%2==0)
                sb.append(nums.get(1)).append(nums.get(0));
            else
                sb.append(nums.get(0)).append(nums.get(1));
            return ;
        }
        int interval = divide/nums.size();
        int insert = nums.get((k-1)%divide/interval);
        nums.remove((k-1)%divide/interval);
        sb.append(insert);
        getNextInt(k, interval,nums,sb);
        return ;
    }
}
