package LeetCode051_100;

/**
 * class: Solution069
 *
 * @author 刘天雅
 * @date 2018/03/06
 */
/*
用牛顿迭代法，据说
 */
public class Solution069
{
    int mySqrt(int x)
    {
        if(x<1)
            return 0;
        if(x == 1)
            return 1;
        double oldValue = x/2;
        double newValue = x/2;
        do{
            oldValue = newValue;
            newValue =  oldValue - (oldValue*oldValue - x)/(2.0*oldValue);
        }while(Math.abs(oldValue - newValue)> 1);
        return (int)newValue;
    }
}
