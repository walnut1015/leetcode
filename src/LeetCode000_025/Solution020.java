package LeetCode000_025;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tanya on 2017/6/14.
 */
public class Solution020
{
    public boolean isValid(String s)
    {
        if(s==null)
            return false;
        if(s.equals(""))
            return true;
        boolean flag = false;
        Stack<Character> brakets = new Stack<>();
        for(int i =0;i<s.length();i++)
        {
            char c = s.charAt(i);
            switch (c)
            {
                case '(':;
                case '[':;
                case '{':
                    brakets.push(c);
                    break;
                case ')':;
                case ']':;
                case '}':
                    if(brakets.isEmpty() || (!isPair(brakets.peek().charValue(),c)))
                    {
                        flag=true;
                        break;
                    }
                    if(isPair(brakets.peek().charValue(),c))
                    {
                        brakets.pop();
                        break;
                    }
                default:break;
            }
            if(flag)
                break;
        }
        if(flag || (!brakets.empty()))
            return false;
        else
            return true;
    }
    private boolean isPair(char a, char b)
    {
        if(a=='(' && b==')')
            return true;
        if(a=='[' && b==']')
            return true;
        if(a=='{' && b=='}')
            return true;
        return false;
    }
}
