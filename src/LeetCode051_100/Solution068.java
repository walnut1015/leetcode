package LeetCode051_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tanya on 2017/11/3.
 */
public class Solution068
{
/*    public List<String> fullJustify(String[] words, int maxWidth)
    {
        if(words == null || words.length==0)
            return new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);
        Map<Integer,Integer> map = new HashMap();

        int index = 0;
        for(int i = 1; i<words.length;i++)
        {
            sb.append(" "+words[i]);
            index += words[i].length()+1;
            map.put(index,i);
        }
        sb.append(".");
        String str = sb.toString();
        int widWithSpace = 0;
        int width = 0;
        for(int i = 0;i<words.length;)
        {
            width += words[i].length();
            widWithSpace += words[i].length()+1;
            if(widWithSpace < maxWidth )
            {
                    i++;
            }
            else if(map.get(i)!=null || map.get(i+1) != null)
            {
                int spaces = widWithSpace;
            }

        }
    }*/
}





















