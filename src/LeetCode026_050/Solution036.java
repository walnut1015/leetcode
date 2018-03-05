package LeetCode026_050;

/**
 * Created by Tanya on 2017/7/8.
 */
//读取
//如何高效地判断数组中
// 我的代码十分的繁琐。参考他人代码：加上3个3x3的数组来分别记录在行，列，子方块中数字是否已经存在，会简单很多。

public class Solution036
{
    public boolean isValidSudoku(char[][] board)
    {
        int [][]rowRepeated = new int[10][10];
        int [][]colRepeated = new int[10][10];
        int [][]boxRepeated = new int[10][10];
        for(int i =0;i<9;i++)
            for(int j = 0; j < 9;j++)
            {
                if(board[i][j]!='.')
                {
                    int num = board[i][j] - '0';
                    int m = i, n = j, k = i/3*3 + j/3;
                    if(rowRepeated[i][num]!=0 || colRepeated[j][num]!=0 || boxRepeated[k][num]!=0)
                        return false;
                    rowRepeated[i][num] = 1;
                    colRepeated[j][num] = 1;
                    boxRepeated[k][num] = 1;
                }
            }
        return true;
    }

    int len;
    public boolean isValidSudoku1(char[][] board)
    {
        this.len = board.length;
        for(int i = 0;i<len;i++)
            if(isRepeated(board[i]))
                return false;
        for(int i =0;i<len;i++)
            if(isRepeatedVertical(board,i))
                return false;
        for(int i =0;i<len/3;i++)
        {
            for(int j = 0; j<len/3;j++)
            {
                if(isRepeatedSquare(board, 3*i, 3*j))
                    return false;
            }
        }
        return true;
    }
    private boolean isRepeatedSquare(char[][] board, int m, int n)
    {
        int [] count = new int[10];
        for(int i =0;i<3;i++)
        {
            for(int j = 0;j<3;j++)
            {
                if(board[m+i][n+j]-'0'>=0 && board[m+i][n+j]-'0'<=9)
                {
                    count[board[m+i][n+j] - '0']++;
                    if (count[board[m+i][n+j] - '0'] > 1)
                        return true;
                }
            }
        }
        return false;
    }
    private boolean isRepeatedVertical(char[][] board, int col)
    {
        int [] count = new int[10];
        for(int i = 0;i<len;i++)
        {
            if(board[i][col]-'0'>=0 && board[i][col]-'0'<=9)
            {
                count[board[i][col] - '0']++;
                if (count[board[i][col] - '0'] > 1)
                    return true;
            }
        }
        return false;
    }
    private boolean isRepeated(char[] chars)
    {
        int [] count = new int[10];
        for(int i = 0;i<len;i++)
        {
            if(chars[i]-'0'>=0 && chars[i]-'0'<=9)
            {
                count[chars[i]-'0']++;
                if (count[chars[i] - '0'] > 1)
                    return true;
            }
        }
        return false;
    }

}
