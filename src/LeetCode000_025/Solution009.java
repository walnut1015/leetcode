package LeetCode000_025;

/**
 * Created by Tanya on 2017/3/3.
 * 将字符串倒过来以两个字符串的最长公共子串来判断原字符串的最长回文串是错误的
 * 但是将元字符串倒过来，看两个字符串是否相等，可以由此判断元字符串是否为回文串
 */
public class Solution009 {
    public static void mains(String []args)
    {
        Solution009 s = new Solution009();
        System.out.print(s.isPalindrome(-2147447412));
    }
    public boolean isPalindrome(int x)
    {
        if(x<0) return false;
        int num = x;
        int inv = 0;
        while(num != 0)
        {
            inv = inv*10 + num%10;
            num/=10;
        }
        return inv==x;
    }
}