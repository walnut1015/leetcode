package LeetCode026_050;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Tanya on 2017/7/3.
 */
//共有4个solution:longestValidParentheses方法
// longestValidParentheses1：完全自己做的，在去掉内部类，并且用数组来取代stack类之后，在其中一个数据集上运行的时间变为了使
// 用stack类时的1/3，曾超过94%的solutions.
//java数字类型的变量默认初始值是0，知道这一点可能会省去一些数组初始化的开销
// 在结合longestValidParentheses做了进一步的修改之后，弃用了flags数组，开销以及时间都有了进一步的减少。
// longestValidParentheses2：来自许鸿翔，原理不详
// longestValidParentheses3：来自许鸿翔改写之后的版本，将Stack类改为了LinkedList类
// longestValidParentheses：来自Solutions中的解法。
//同时该题还有动态规划的解法，也很有意思。
public class Solution032
{
    private class Parenthesis
    {
        public int pos;
        public char parenthethis;
        Parenthesis(int pos, char parenthethis)
        {
            this.pos = pos;
            this.parenthethis = parenthethis;
        }
    }
    public int longestValidParentheses1(String s)
    {
        int len = 0;
        if(s.length()==0)
            return len;
        char [] chars = s.toCharArray();
        //int []flags = new int[s.length()];
        int []stack = new int[s.length()];
        int stackLen = 0;
        stack[stackLen++] = 0;
        for(int i = 1;i<s.length();i++)
        {
            if(stackLen!=0)
            {
                if (chars[i] == ')' && chars[stack[stackLen-1]] == '(')
                {
                    //flags[stack[stackLen-1]] = 1;
                    //flags[i] = 1;
                    stackLen--;
                    continue;
                }
            }
            stack[stackLen] = i;
            stackLen++;
        }
        if(stackLen==0)
            return s.length();
        else
            len = Math.max(len, s.length()-stack[stackLen-1]-1);
        while(stackLen>1)
            len = Math.max(len, stack[--stackLen]-stack[stackLen-1]-1);
        if(stackLen>0)
            len = Math.max(len, stack[stackLen-1]);
        return len;

        /*for(int i = 0;i<s.length();i++)
        {
            int count = 0;
            if(flags[i]>0)
            {
                count++;
                i++;
                while(i<s.length() && flags[i]>0)
                {
                    count++;
                    i++;
                }
            }
            if(count>len)
                len = count;
        }
        return len;*/
    }
    public int longestValidParentheses(String s)
    {
        int len = 0;
        if(s.length()==0)
            return len;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1;i<s.length();i++)
        {
            if(!stack.isEmpty())
            {
                if (s.charAt(i) == ')' && s.charAt(stack.peek().intValue()) == '(')
                {
                    stack.pop();
                    continue;
                }
            }
            stack.push(i);
        }
        if(stack.isEmpty())
            return s.length();
        else
            len = Math.max(len, s.length() - stack.peek().intValue() -1);
        while(stack.size()>1)
        {
            int right = stack.pop();
            len = Math.max(len, right - stack.peek().intValue() -1);
        }
        if(!stack.isEmpty())
            len = Math.max(len, stack.peek().intValue());
        return len;
    }
    public int longestValidParentheses2(String s) {
        int ans=0;
        int slength = s.length();
        char[] cs = s.toCharArray();
        if(slength<2) return 0;
        int[] parent = new int[slength];
        boolean[] marked = new boolean[slength];
        int[] length = new int[slength];

        parent[0] = -1;
        for(int i=1;i<slength;i++){
            if(cs[i]=='('){
                if(cs[i-1]=='('){
                    parent[i] = i-1;
                }else{
                    parent[i] = parent[i-1];
                }
            }else{
                if(cs[i-1]=='('){
                    int toPro = i-1;
                    parent[i] = toPro;
                    marked[toPro] = true;
                    length[toPro]=2;
                    ans = ans<2?2:ans;
                    while(parent[toPro]>=0&&marked[toPro]){
                        length[parent[toPro]] +=2;
                        toPro = parent[toPro];
                        ans = ans<length[toPro]?length[toPro]:ans;
                    }
                }else{
                    int toPro = parent[i-1];
                    parent[i] = -1;
                    while(toPro>=0){
                        if(marked[toPro]){
                            toPro = parent[toPro];
                        }else{
                            int toadd = length[toPro]+2;
                            parent[i] = toPro;
                            marked[toPro] = true;
                            length[toPro] = toadd;
                            ans = ans<toadd?toadd:ans;
                            while(parent[toPro]>=0&&marked[toPro]){
                                length[parent[toPro]] += toadd;
                                toPro = parent[toPro];
                                ans = ans<length[toPro]?length[toPro]:ans;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
    public int longestValidParentheses3(String s)
    {
        int len = 0;
        if(s.length()==0)
            return len;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for(int i = 1;i<s.length();i++)
        {
            if(!stack.isEmpty())
            {
                if (s.charAt(i) == ')' && s.charAt(stack.peek()) == '(')
                {
                    stack.pop();
                    continue;
                }
            }
            stack.push(i);
        }
        if(stack.isEmpty())
            return s.length();
        else
            len = Math.max(len, s.length() - stack.peek() -1);
        while(stack.size()>1)
        {
            int right = stack.pop();
            len = Math.max(len, right - stack.peek() -1);
        }
        if(!stack.isEmpty())
            len = Math.max(len, stack.peek());
        return len;
    }

}
