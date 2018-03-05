package Test026_050;

import LeetCode000_025.Solution;
import LeetCode026_050.Solution036;
import org.junit.Test;
import org.omg.CORBA.portable.Streamable;

/**
 * Created by Tanya on 2017/7/8.
 */
public class Test_036 {
    @Test
    public void test()
    {
        Solution036 sol = new Solution036();
        char [][]board = new char[9][9];
        String []strs = {"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
        for(int i =0;i<9;i++)
        {
            board[i] = strs[i].toCharArray();
        }
        System.out.println(sol.isValidSudoku(board));
    }
}
