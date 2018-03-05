package LeetCode026_050;

/**
 * Created by Tanya on 2017/8/15.
 */
public class Solution043
{
    public String multiply(String num1, String num2)
    {
        //一开始么有考虑到有一方为零的情况。
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        char[]numChars1 = num1.toCharArray();
        char[]numChars2 = num2.toCharArray();
        if(len1==0 || len2==0 || len1>110 || len2>110)
            return null;
        int []res = new int [len1+len2];
        for(int i = 0;i<len1;i++)
        {
            for(int j = 0;j<len2;j++)
            {
                int pos = len1+len2-i-j-1;
                int curRes = 10*(res[pos-1])+ res[pos]+(numChars1[len1-1-i]-'0')*(numChars2[len2-1-j]-'0');
                res[pos] = curRes%10;
                res[pos-1] = curRes/10;
            }
        }
        int i = 0;
        while(res[i]==0) i++;
        while(i<res.length)
            sb.append(res[i++]);
        return sb.toString();
    }
}
