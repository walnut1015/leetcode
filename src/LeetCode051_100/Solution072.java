package LeetCode051_100;

import java.util.Arrays;

/**
 * class: Solution072
 *
 * @author 刘天雅
 * @date 2018/03/11
 */
//计算两个单词，一个单词转换成另外一个所需的最小操作数（增、删、换）
//最关键的步骤应该是让两个字符串对齐。
public class Solution072 {
/*    public int minDistance(String word1, String word2) {
        int[][] maxSameChars = new int[word1.length()+1][word2.length()+1];
        Arrays.fill(maxSameChars[word1.length()+1],0);
        for(int i = word1.length()-1;i>=0;i--)
            for(int j = word2.length()-1;j>=0;j--)
            {
                if(word1.charAt(i) == word2.charAt(j))
                    maxSameChars[i][j] = maxSameChars[i+1][j+1]+1;
                else maxSameChars[i][j] = Math.max(Math.max(maxSameChars[i+1][j],maxSameChars[i][j+1]),maxSameChars[i+1][j+1]);
            }


    }*/

    public int minDistance(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        int[][] minDistance = new int[word1.length()+1][word2.length()+1];
        for(int j = 0;j<word2.length()+1;j++)
            minDistance[0][j] = j;
        for(int i = 0;i<word1.length()+1;i++)
            minDistance[i][0] = i;
        for(int i = 1;i<str1.length+1;i++)
        {
            for(int j = 1;j<str2.length+1;j++)
            {
                int temp1;
                if(str1[i-1]==str2[j-1])
                    temp1 = minDistance[i-1][j-1];
                else
                    temp1 = minDistance[i-1][j-1]+1;
                minDistance[i][j] = Math.min(Math.min(temp1,minDistance[i-1][j]+1),minDistance[i][j-1]+1);
            }
        }
        return minDistance[str1.length][str2.length];
    }
}
