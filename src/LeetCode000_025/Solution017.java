package LeetCode000_025;

import java.util.*;
/*用FIFO队列来做*/
public class Solution017
{
    public List<String> letterCombinations(String digits)
    {

        List<String> res = new LinkedList<>();
        //我的想法是用树的先序遍历来做。
        Queue<String> wordsQueue = new ArrayDeque<>();
        int len = digits.length();
        if(len==0) return res;
        String []letters = {"0","1","a b c","d e f","g h i","j k l","m n o","p q r s","t u v","w x y z"};
        String []strs = letters[digits.charAt(0)-'0'].split(" ");
        for(String str:strs)
        {
            wordsQueue.add(str);
        }
        for(int i = 1;i<len;i++)
        {
            strs = letters[digits.charAt(i)-'0'].split(" ");
            while(wordsQueue.peek().length()==i)
            {
                String head = wordsQueue.remove();
                String temp = new String(head);
                for(String str:strs)
                {
                    head = temp;
                    head = head.concat(str);
                    wordsQueue.add(head);
                }
            }
        }
        while(!wordsQueue.isEmpty())
            res.add(wordsQueue.remove());
        return res;
    }
}