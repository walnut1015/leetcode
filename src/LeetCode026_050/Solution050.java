package LeetCode026_050;

/**
 * Created by Tanya on 2017/9/10.
 */
public class Solution050
{
    public double myPow(double x, int n)
    {
        if(x == 1 || x ==0 || n == 1)
            return x;
        if(n<0)
            return 1.0/myPowUtil(x, -1*n);
        else
            return myPowUtil(x,n);
    }
    private double myPowUtil(double x, int n)
    {
        if(n == 1)
            return x;
        if(n == 0)
            return 1;
        //从myPowUtil(x,n/2)*myPowUtil(x,n/2)变成了 ans = myPowUtil(x,n/2), ans*ans 使得速度提高了一倍。
        double ans = myPowUtil(x, n/2);
        if(n%2==0)
            return ans*ans;
        else return x*ans*ans;
    }
}
