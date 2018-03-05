package LeetCode051_100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tanya on 2017/10/17.
 */
public class Solution065
{
    public boolean isNumber(String s) {
        s = s.trim();
        int[][] trans = {{1, -1, 2, 1},
                {1, -1, 2, -1},
                {2, -1, 3, -1},
                {4, -1, -1, 4},
                {4, -1, -1, -1}
        };
        int state = 0;
        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                if (state == 0 || state == 1)
                    state = 1;
                else if (state == 3 || state == 4)
                    state = 4;
                else if (state == 2)
                    state = 2;
            } else if (s.charAt(i) == 'e') {
                if (state == 2)
                    state = 3;
                else
                    return false;
            } else if (s.charAt(i) == '.') {
                if (state == 1 || state == 0)
                    state = 2;
                else
                    return false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (state == 3)
                    state = 4;
                else
                    return false;
            } else
                return false;

            if ((state == 1 || state == 2 || state == 4) && i+1 == s.length())
//                state = 5;
//            if(state == 5)
                return true;
        }
        return false;
    }
}
