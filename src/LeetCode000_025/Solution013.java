package LeetCode000_025;

import java.util.TreeMap;

/**
 * Created by Tanya on 2017/3/17.
 */
public class Solution013
{
    public int romanToInt(String s)
    {
        int sum = 0;
        int i = 0;
        for(; i<s.length()-1;)
        {
            if(trans2int(s.charAt(i))<trans2int(s.charAt(i+1)))
            {
                sum += trans2int(s.charAt(i+1))-trans2int(s.charAt(i));
                i+=2;
            }
            else   sum += trans2int(s.charAt(i++));
        }
        if(i==s.length()-1) sum += trans2int(s.charAt(s.length()-1));
        return sum;

    }
    public int trans2int(char input)
    {
        switch (input)
        {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
