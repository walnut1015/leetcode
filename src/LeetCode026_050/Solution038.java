package LeetCode026_050;

/**
 * Created by Tanya on 2017/7/11.
 */
//应当判断出数字串中不会出现连续多于3个相同的数字。
public class Solution038
{
    public String countAndSay(int n)
    {
        //if(n ==)
        if(n==1)
            return "1";
        return count("1",n-1);
    }
    public String count(String str,int n)
    {
        if(n==0)
            return str;
        StringBuilder sb = new StringBuilder();
        if(str.length() == 0)
            return "";
        char []chars = str.toCharArray();
        char curVal = chars[0];
        int len = str.length();
        int tok = 0;
        for(int i = 1;i<len ;i++)
        {
            if(chars[i]!=curVal)
            {
                sb.append(i-tok).append(chars[tok]);
                tok = i ;
                curVal = chars[tok];
            }
        }
        sb.append(len-tok).append(chars[tok]);
        return count(sb.toString(),n-1);
    }
        String []nums = {"0","1","2","3"};
    public String countAndSay2(int n)
    {
        if(n==1)
            return "1";
        String str = countAndSay(n-1);
        StringBuilder res = new StringBuilder(); //StringBUilder比新建String类大幅提升了速度
        if(str.length() == 0)
            return res.toString();
        char []chars = str.toCharArray();
        char curVal = chars[0];
        int len = str.length();
        int tok = 0;
        for(int i = 1;i<len ;i++)
        {
            if(chars[i]!=curVal)
            {
                res.append(i - tok).append(chars[tok]);
                tok = i ;
                curVal = chars[tok];
            }
        }
        res.append(len-tok).append(chars[tok]);
        return res.toString();

    }
    private String count(String str)
    {
        String res = "";
        if(str.length() == 0)
            return res;
        char []chars = str.toCharArray();
        char curVal = chars[0];
        int len = str.length();
        int tok = 0;
        for(int i = 1;i<len ;i++)
        {
            if(chars[i]!=curVal)
            {
                res += nums[i - tok];
                res += chars[tok];
                tok = i ;
                curVal = chars[tok];
            }
        }
        res += nums[len-tok];
        res +=str.charAt(tok);
        return res;
    }
}
