package LeetCode000_025;

/**
 * Created by Tanya on 2017/3/7.
 */
public class Solution010 {
    public static void mains(String []args)
    {
        Solution010 s = new Solution010();
        System.out.print(s.isMatch("aab","c*a*b"));
    }
    public boolean isMatch(String s, String p)
    {
        if(s==null || p== null)
            return false;
        int ls = s.length(), lp = p.length();
        boolean [][]dp = new boolean[ls+1][lp+1];
        dp[0][0] = true;
        for(int i =0 ;i < lp;i++)
        {
            if(p.charAt(i)=='*'&& dp[0][i-1]==true)
                dp[0][i+1] = true;
        }
        for(int i=0;i<ls;i++)
        {
            for(int j = 0;j<lp;j++)
            {
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
                    dp[i+1][j+1] = dp[i][j];
                if(p.charAt(j)=='*')
                {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        //dp[i][j+1]表示s中第
                    } else
                    {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[ls][lp];
    }
}