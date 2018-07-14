package LeetCode051_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * class: Solution071
 *
 * @author 刘天雅
 * @date 2018/03/11
 */
public class Solution071
{
    //这个方法看起来特别复杂，if、else很多，以后应该尽可能想到更简单的做法。
    public String simplifyPath2(String path)
    {
        char[] chars = new char[path.length()];
        Arrays.fill(chars,'\n');
        int len = path.length();
        int charsIndex = 0;
        for(int i = 0;i<len;i++ )
        {
            char temp = path.charAt(i);
            switch (temp)
            {
                case '.':
                    if(charsIndex==0)
                        chars[charsIndex++] = '.';
                    else if(chars[charsIndex-1]=='.')
                    {
                        if(charsIndex == 2 && chars[charsIndex-2]=='/')
                            charsIndex = 1;
                        else if(charsIndex > 2 && chars[charsIndex-2]=='/')
                            charsIndex -= 3;
                    }
                    else chars[charsIndex++] = temp;
                    break;
                case '/':
                    if(chars[charsIndex-1]=='/')
                        break;
                    else
                        chars[charsIndex++] = temp;
                    break;
                default:
                    chars[charsIndex++] = temp;
                    if(charsIndex==0)
                        break;
            }
        }
        return null;
         }
//
    public String simplifyPath(String path)    {
        String[] pieces = new String[path.length()];
        int charsIndex = 0;
        for(String str:path.split("/"))        {
            if(str.equals("."))
                continue;
            if(str.equals(".."))
                if(charsIndex != 0){
                    charsIndex--;
                }
            else if(str.length()>0)
                pieces[charsIndex++] = str;
        }
        StringBuilder sb = new StringBuilder();
        if(charsIndex == 0)
            return "/";
        for(int i = 0;i<charsIndex;i++)
        {
            sb.append("/" + pieces[i]);
        }
        return sb.toString();
    }
}
