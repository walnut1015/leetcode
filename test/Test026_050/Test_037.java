package Test026_050;

import LeetCode026_050.Solution036;
import LeetCode026_050.Solution037;
import org.junit.Test;

/**
 * Created by Tanya on 2017/7/8.
 */
public class Test_037
{
    @Test
    public void test()
    {
        Solution037 sol = new Solution037();
        char [][]board = new char[9][9];
        String []strs = {"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
        for(int i =0;i<9;i++)
        {
            board[i] = strs[i].toCharArray();
        }
        sol.solveSudoku(board);
        Solution036 sol2 = new Solution036();
        System.out.println(sol2.isValidSudoku(board));
    }
}
