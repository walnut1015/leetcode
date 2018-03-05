package LeetCode000_025;

/**
 * Created by Tanya on 2017/2/27.
 */
/*一开始想用栈来解决这个问题，但是栈不能识别回文串中嵌套回文串的情况。
*因此用动态规划。时间复杂度为O(n^2)
* 做题过程中要画出矩阵中各个元素赋值所依赖的元素以确定先后顺序
* longestPalindrome1（）函数中注释部分是超时的，而该函数改了的部分则会有赋值顺序不正确的问题。
* */
public class Solution005 {
    public static void mains(String []args)
    {
        String str = "cbbd";
        //String str ="aaaaaaa";
        Solution005 s = new Solution005();
        System.out.print(s.longestPalindrome(str));
    }
    public String longestPalindrome1(String s)
    {
        String pldstr = new String();
        int longestpldlen = 0;
        int len = s.length();
        int start = 0, end = 0;
        char []chars = new char[len];
        boolean [][]isPalindrome = new boolean[len][len];
        for(int i = 0; i<len;i++) {chars[i] = s.charAt(i);isPalindrome[i][i]=true;}
        for(int i =0;i<len-1;i++) isPalindrome[i][i+1] = (chars[i]==chars[i+1]);
        for(int i = 0; i<len;i++)
        {
            for(int j =i+2;j<len;j++)
            {
                /*if(Math.abs(j-i) == 1) isPalindrome[i][j] =(chars[i]==chars[j]);
                if(i>j+1)
                    isPalindrome[i][j] =((chars[i]==chars[j]) && (isPalindrome[i-1][j+1]==true));
                if(1+i<j)
                    isPalindrome[i][j] =((chars[i]==chars[j]) && (isPalindrome[i+1][j-1]==true));
                if(isPalindrome[i][j]==true && Math.abs(i-j)+1>longestpldlen)
                {
                    longestpldlen = Math.abs(i-j)+1;
                    start = i<j?i:j;
                    end = i>j?i:j;
                }*/
                isPalindrome[i][j] =((chars[i]==chars[j]) && (isPalindrome[i+1][j-1]==true));
                if(isPalindrome[i][j]==true && j-i+1>longestpldlen)
                {
                    longestpldlen = j-i+1;
                    start = i;
                    end = j;
                }
            }
        }
        pldstr = s.substring(start, end+1);
        return pldstr;
    }

    public String longestPalindrome(String s)
    {
        if(s.equals("")) return "";
        String pldstr = new String();
        int longestpldlen = 1;
        int len = s.length();
        int start = 0, end = 0;
        char []chars = new char[len];
        boolean [][]isPalindrome = new boolean[len][len];
        for(int i = 0; i<len;i++) {chars[i] = s.charAt(i);isPalindrome[i][i]=true;}
        for(int i =0;i<len-1;i++)
            if(isPalindrome[i][i+1] = (chars[i]==chars[i+1]))
            {
                longestpldlen = 2;
                start = i;
                end = i+1;
            }
        for(int k = 2;k<len;k++)
        {
            for(int i = 0;i+k<len;i++)
            {
                isPalindrome[i][i+k] = (isPalindrome[i+1][i+k-1] && chars[i]==chars[i+k]);
                if(isPalindrome[i][i+k])
                {
                    longestpldlen = k+1;
                    start = i;
                    end = i+k;
                }
            }
        }
        pldstr = s.substring(start, end+1);
        return pldstr;
    }

}