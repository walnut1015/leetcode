package LeetCode026_050;

/**
 * Created by Tanya on 2017/7/2.
 */
public class Solution029
{
    public int divide(int dividend, int divisor)
    {
        if(divisor==0 ||(dividend==Integer.MIN_VALUE && divisor==-1))
            return Integer.MAX_VALUE;
        long unsDividend = Math.abs((long)dividend);//这两句很重要。Math.abs()函数返回值和输入参数值是一个类型的，所以如果输入
                                                     //的int型数字是Integer.MIN_VALUE的话，应当把输入参数强制转换成long型的。
        long unsDivisor = Math.abs((long)divisor);
        int symbol = 1;
        if((dividend>0 && divisor<0) ||(dividend<0 && divisor >0))
            symbol = -1;
        int count = 0;
        long curDivisor = unsDivisor;
        for(;unsDividend >0;)
        {//提升效率的关键
            if(curDivisor<<1 <= unsDividend)
            {
                int i = 1;
                while (curDivisor << 1 <= unsDividend)
                {
                    i = i << 1;
                    curDivisor = curDivisor << 1;
                }
                count += i;
            }
            else if(curDivisor <= unsDividend)
            {
                count+=1;
            }
            unsDividend -=curDivisor;
            curDivisor = unsDivisor;
        }
        return count*symbol;
    }
}
