package LeetCode000_025;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tanya on 2017/2/22.
 * target of this program is to find the longest non-repeating substring of a input string
 */

public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int res = 0;
        /*如何快速判断一个字符串里面是否有重复呢？*/
        int length = s.length();
        Map<String, Integer> maps = new HashMap<String, Integer>();
        maps.put(String.valueOf(s.charAt(0)),0);
        char []str = new char[length];
        for(int i =0;i<length;i++)
        {
            str[i] = s.charAt(i);
        }
        int []last = new int[length];
        last[0] = -1;
        for(int i =1;i<length;i++)
        {
            String current = String.valueOf(str[i]);
            if(maps.containsKey(current))
            {
                int lastindex = maps.get(current).intValue();
                maps.put(current, i);
                last[i]=lastindex;
            }
            else
            {
                maps.put(current, i);
                last[i] = -1;
            }
        }
        int l=0,r=0;
        while (r < length)
        {
            if(r == length-1)
                if(last[r]>=l)
                {
                    break;
                }
                else
                {
                    res = max(res, r-l+1);
                    r++;
                }
            else
            {
                if(last[r] >= l)
                {
                    l = last[r] + 1;
                    r++;
                }
                else
                {
                    res = max(res, r - l + 1);
                    r++;
                }
            }
        }
        return res;
    }
    int max(int a, int b)
    {
        return a>b?a:b;
    }
    public void main1(String []args)
    {
        Solution003 a = new Solution003();
        System.out.print(a.lengthOfLongestSubstring("abcabcbb"));
    }
}
