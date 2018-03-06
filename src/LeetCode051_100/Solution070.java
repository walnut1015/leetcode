package LeetCode051_100;

/**
 * class: Solution070
 *
 * @author 刘天雅
 * @date 2018/03/06
 */
//看了别人的代码之后发现根本不用数组就可以完成；
public class Solution070
{
    public int climbStairs(int n)
    {
        if(n <= 0)
            return 0;
        if(n ==1 )
            return 1;
        int pre = 1;
        int cur = 2;
        int temp;
        for(int i = 2;i<n;i++)
        {
            temp = cur;
            cur +=pre;
            pre = temp;
        }

        return cur;
    }
}
