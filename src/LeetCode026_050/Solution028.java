package LeetCode026_050;

/**
 * Created by Tanya on 2017/6/19.
 */
public class Solution028
{
    public int strStr(String haystack, String needle) {
        int firstOccurrence = -1;
        if(needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return firstOccurrence;
        for (int i = 0; i < haystack.length()-needle.length()+1 ; i++)
        {
            int j = i,k=0;
            //boolean flag  = false;
            while(k<needle.length() && haystack.charAt(j)==needle.charAt(k))
            {
                k++;j++;
            }
            if(k==needle.length())
                return i;
        }
        return firstOccurrence;
    }
}
