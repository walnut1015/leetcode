package LeetCode051_100;

/**
 * Created by Tanya on 2017/10/18.
 */
public class Solution066
{
    public int[] plusOne(int[] digits)
    {
        if(digits== null || digits.length==0)
            return digits;
        int forward = 1;
        int nextforward = 0;
        int i = digits.length-1;
        for(;i>=0;i--)
        {
            nextforward = digits[i] + forward;
            digits[i] = nextforward%10;
            nextforward = nextforward/10;
            if(nextforward == 1)
            {
                forward = 1;
                nextforward = 0;
            }
            else return digits;
        }
        if(i==-1 && forward ==1)
        {
            int[] res = new int[digits.length+1];
            for(i = digits.length;i>0;i--)
                res[i] = digits[i-1];
            res[0] = 1;
            return res;
        }

        return digits;
    }
}
