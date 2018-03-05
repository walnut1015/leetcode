package LeetCode051_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tanya on 2017/9/11.
 */
public class Solution052
{
    int size;
    public int totalNQueens(int n)
    {
        this.size = n;
        char [][] board = new char[n][n];
        for (int i = 0;i<n;i++)
            Arrays.fill(board[i],'.');
        return solve(0, board);
    }
    //n表示目前是在第几行放置皇后，在该行的每一列都试一下看看能不能成。
    private int solve(int i, char [][] board)
    {
        if(i==size) //则表明board已经有了
        {
            return 1;
        }
        //在每一列都试试看能不能成
        int num =0;
        for(int j = 0;j<size;j++)
        {
            board[i][j] = 'Q';
            if(isValid(i,j,board))
            {
                num += solve(i+1, board);
            }
            board[i][j] = '.';
        }
        return num;
    }
    private boolean isValid(int i, int j, char [][] board)
    {
        for(int k = 1;k<size;k++)
        {
            if (i + k < size && j + k < size)
                if (board[i + k][j + k] == 'Q')
                    return false;
            if(i+k<size && j-k >-1)
                if (board[i + k][j-k] == 'Q')
                    return false;
            if (i - k > -1 && j + k < size)
                if (board[i - k][j + k] == 'Q')
                    return false;
            if (i - k > -1 && j - k > -1)
                if (board[i - k][j - k] == 'Q')
                    return false;
        }
        for(int k = 0;k!= j && k<size;k++)
        {
            if(board[i][k]=='Q')
                return false;
        }
        for(int k = 0;k!= i && k<size;k++)
        {
            if(board[k][j]=='Q')
                return false;
        }
        return true;
    }

}
