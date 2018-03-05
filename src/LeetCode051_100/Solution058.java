package LeetCode051_100;

/**
 * Created by Tanya on 2017/10/7.
 */
public class Solution058
{
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0)
            return 0;
//        int i = s.length()-1;
//        int j =s.length();
//        for(;i>-1;i--)
//            if(s.charAt(i)==' ')
//                if((j<s.length() && s.charAt(i+1)==' ') || j==s.length())
//                    j=i;
//                else
//                    return j-i-1;
//        return j;
//        String[] strs = s.split(" ");
//        if(strs.length==0)
//            return 0;
//        return strs[strs.length-1].length();
        boolean wordAppear = false;
        int len  = 0;
        for(int i = s.length()-1;i>-1;i--)
        {
            if(s.charAt(i)!=' ')
            {
                wordAppear = true;
                len++;
            }
            else if(s.charAt(i)==' '&& wordAppear)
                break;
        }
        return len;


    }
}
