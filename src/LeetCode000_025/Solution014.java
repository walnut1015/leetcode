package LeetCode000_025;

/**
 * Created by Tanya on 2017/3/17.
 */
public class Solution014
{
    public String longestCommonPrefix(String[] strs)
    {
        int len = strs.length;
        String commonPrefix = "";
        if(len==0) return "";
        boolean flag = true;
        int j = 0;
        int minlen = strs[0].length();
        for(int i =0;i<len;i++) minlen = minlen<strs[i].length()?minlen:strs[i].length();
        if(minlen==0) return "";
        while(flag && j<minlen)
        {
            char temp = strs[0].charAt(j);
            for(int i = 0; i<len;i++)
            {
                if(strs[i].charAt(j) != temp) flag = false;
            }
            if(flag) commonPrefix += temp;
            j++;
        }
        return commonPrefix;
    }
}
