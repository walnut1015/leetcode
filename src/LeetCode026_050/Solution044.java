package LeetCode026_050;

import java.util.Arrays;

/**
 * Created by Tanya on 2017/8/17.
 */
//用动态规划，dp[i][j]表示str1中子串1-i    与str2中子串1-j的匹配结果true/false;
//用这种方法边界条件很多，在没有
public class Solution044
{
    public boolean isMatch(String s, String p)
    {
        if(s.length()==0 && p.length()==0)
            return true;
        if(p.equals("*"))
            return true;
        if(s.length()==0 || p.length()==0)
            return false;

        int len1 = p.length(),len2 = s.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        for(int i =0;i<len1+1;i++)
        {
            Arrays.fill(dp[i],false);
        }
        dp[0][0] = true;

        boolean nullStarFlag = false;
        if(p.charAt(0)==s.charAt(0) || p.charAt(0)=='?')
            dp[1][1] = true;
        else if(p.charAt(0)=='*')
        {
            for(int j = 1;j<len2+1;j++)
                dp[1][j] = true;
            nullStarFlag = true;
        }
        for (int i = 2; i<len1+1;i++)
        {
            for(int j = 1;j<len2+1;j++)
            {
                if(nullStarFlag) {
                    if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='?')
                    {
                        dp[i][j] = dp[i-1][j-1]||dp[i - 1][j];
                    }
                    if(p.charAt(i-1)!='*')
                        nullStarFlag = false;
                    else
                        dp[i][j] = true;
                }
                else if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(i-1)=='*')
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                else dp[i][j] = false;
            }

        }
        return dp[len1][len2];
    }
}
