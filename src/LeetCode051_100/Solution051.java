package LeetCode051_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tanya on 2017/9/10.
 */
public class Solution051
{
     //board;
    int size;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n)
    {
        this.size = n;
        char [][] board = new char[n][n];
        res = new LinkedList<>();
        for (int i = 0;i<n;i++)
            Arrays.fill(board[i],'.');
        solve(0, board);
        return res;
    }
    //n表示目前是在第几行放置皇后，在该行的每一列都试一下看看能不能成。
    private void solve(int i, char [][] board)
    {
        if(i==size) //则表明board已经有了
        {
            List<String> list = new LinkedList();
            for(int k =0;k<size;k++)
            {
                list.add(new String(board[k]));
            }
            res.add(list);
            return;
        }
        //在每一列都试试看能不能成
        for(int j = 0;j<size;j++)
        {
            board[i][j] = 'Q';
            if(isValid(i,j,board))
            {
                solve(i+1, board);
            }
            board[i][j] = '.';
        }
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
