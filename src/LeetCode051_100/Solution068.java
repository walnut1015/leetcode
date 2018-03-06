package LeetCode051_100;

import java.util.*;

/**
 * Created by Tanya on 2017/11/3.
 */
public class Solution068
{
    public List<String> fullJustify(String[] words, int maxWidth)
    {
        List<String> res = new ArrayList<>();
        if(words !=null && words.length>0) {
            int lineStart = 0; //当前这批处理的字符串在words数组中的起始索引
            int lineNum = 0;   //当前需要在第几个list res 的 元素中添加字符串
            int totalWordLen = 0; //当前这批总共处理到的字符串的长度之和
            int wordCount = 0; //当前这批总共处理到了几个字符串
            for (int i = 0; i < words.length; i++)
            {
                totalWordLen += words[i].length();
                if(words[i].trim().length()>0)
                    wordCount++;
                if (maxWidth < (wordCount - 1 + totalWordLen))// 想继续写 QAQ
                {
                    wordCount--;
                    totalWordLen -= words[i].length();
                    StringBuilder sb = new StringBuilder();
                    int extraSpacesNum = 0;
                    if(wordCount>1)
                    {
                        for(int j = lineStart;j<i;j++)
                        {
                            sb.append(words[j]);
                            for(int k = 0;j<(i-1)&&k<(maxWidth-totalWordLen)/(wordCount-1);k++)
                                sb.append(" ");
                            if(sb.length()<maxWidth && extraSpacesNum++ < (maxWidth-totalWordLen)%(wordCount-1))
                                sb.append(" ");
                        }
                    }
                    else {
                        sb.append(words[lineStart]);
                        while (sb.length()<maxWidth)
                            sb.append(" ");
                    }
                    //res.set(lineNum++, sb.toString());
                    res.add(sb.toString());
                    totalWordLen = 0;
                    wordCount = 0;
                    lineStart = i;
                    i--;
                }
            }
            if(lineStart!=words.length)
            {
                StringBuilder sb = new StringBuilder();
                int i;
                for(i = lineStart;i<(words.length-1) && words[i].trim().length()!=0;i++)
                {
                    sb.append(words[i]+" ");
                }
                if(i == words.length-1)
                    sb.append(words[i]);
                while (sb.length()<maxWidth)
                    sb.append(" ");
                res.add(sb.toString());
            }
        }
        return res;
    }
}





















