package LeetCode051_100;

/**
 * Created by Tanya on 2017/10/18.
 */
public class Solution067
{
    public String addBinary(String a, String b)
    {
        if(a==null || b==null)
            return new String();

        byte[] biRes = new byte [Math.max(a.length(),b.length())];
        int nextForward = 0;
        int forward = 0;
        int i = 0;
        for(;i<a.length() && i<b.length(); i++)
        {
            forward = a.charAt(a.length()-1-i)-'0'+ b.charAt(b.length()-1-i)-'0'+ nextForward;
            nextForward = forward/2;
            biRes[biRes.length-1-i] = (byte)(forward%2 + '0');
        }

        if(i<a.length())
        {
            for(int j = i;j < a.length();j++)
            {
                forward = a.charAt(a.length()-1-j)-'0' + nextForward;
                nextForward = forward/2;
                biRes[biRes.length-1-j] = (byte)(forward%2 + '0');
            }
        }
        else if(i<b.length())
            for(int j = i;j < b.length();j++)
            {
                forward = b.charAt(b.length()-1-j)-'0' + nextForward;
                nextForward = forward/2;
                biRes[biRes.length-1-j] = (byte)(forward%2 + '0');
            }
        if(nextForward!=0)
        {
            byte[] finalRes = new byte [biRes.length+1];
            System.arraycopy(biRes,0,finalRes,1,biRes.length);
            finalRes[0]=1 + '0';
            return new String(finalRes);
        }
        return new String(biRes);
    }
}
