package LeetCode000_025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tanya on 2017/6/15.
 */
public class Solution022
{
    List<String> ret = new ArrayList<>();

    public List<String> generateParenthesis(int n)
    {
        addParenthesis(0,1,n,"(");
        return ret;
    }
//在这里open仅仅指左括号的个数，close指闭合了的括号的对数。
    private void addParenthesis(int close, int open, int max, String curBrackets)
    {
        if(curBrackets.length()==2*max)
        {
            ret.add(curBrackets);
            return;
        }
        if(open<max)
        {
            addParenthesis(close, open+1, max, curBrackets+"(");
        }
        if(close<open)
            addParenthesis(close+1, open, max, curBrackets+")");
    }
    public List<String> generateParenthesis3(int n)
    {
        addParenthesis3(0,1,n,"(");
        return ret;
    }

    private void addParenthesis3(int close, int open, int max, String curBrackets)
    {
        if(close == max && open==0)
        {
            ret.add(curBrackets);
            return;
        }
        if(close > max)  return;
        else if(open ==0)
        {
            addParenthesis3(close, open+1, max, curBrackets+"(");
        }
        else if(open>=1 && open<max)
        {
            addParenthesis3(close, open+1, max, curBrackets+"(");
            addParenthesis3(close+1,open-1, max, curBrackets+")");
        }
        else if(open==max)
        {
            addParenthesis3(close+1,open-1, max, curBrackets+")");
        }
        return;
    }

    List<String> res = new ArrayList<>();
    int size;
    public List<String> generateParenthesis2(int n)
    {
        if(n==0) return res;
        this.size = n;
        Stack<Character> brackets = new Stack<>();
        brackets.add('(');
        addParenthesis2(2, brackets, "(",1);
        return res;
    }
    private void addParenthesis2(int n, Stack<Character> brackets, String curBrackets, int numOfLeft)
    {
        //Stack<Character> brackets = new Stack<>();

        if(n==2*size+1 && brackets.empty())
            res.add(curBrackets);
        else if(brackets.empty())//说明前面已经出现过了
                            // 成对的括号，接下来只能插入左括号。
        {
            brackets.add('(');
            curBrackets = curBrackets.concat("(");//curBrackets中存入的是引用，所以在各个
                                                  // 函数中一直用这个参数，会不会有问题呢？
            numOfLeft++;
            addParenthesis2(n+1, brackets, curBrackets, numOfLeft);
        }
        else if(numOfLeft==size)
        {
            brackets.pop();
            curBrackets = curBrackets.concat(")");//curBrackets中存入的是引用，所以在各个
            // 函数中一直用这个参数，会不会有问题呢？确实有问题。。。相当于在使用一个类的成员变量了。
            addParenthesis2(n+1, brackets, curBrackets, numOfLeft);
        }
        else
        {
            brackets.push('(');
            String temp = curBrackets.concat("(");
            addParenthesis2(n+1, brackets, temp, 1+numOfLeft);
            brackets.pop();
            brackets.pop();
            curBrackets = curBrackets.concat(")");
            addParenthesis2(n+1, brackets, curBrackets, numOfLeft);
        }
    }
}
