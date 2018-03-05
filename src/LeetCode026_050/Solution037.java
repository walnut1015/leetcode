package LeetCode026_050;

/**
 * Created by Tanya on 2017/7/8.
 */
//我自己的想法是回溯法，每一个空格的候选值为与该空格的横，纵，小方格均不重复的值
// 选择候选值个数最少的空格作为第一个填入的空格，每一个空格的候选值为一个set,选择
// 后将该值从set中删除。----------貌似有点太麻烦了，涉及到很多set的更新，以及后选择值的排序。先不这样做。
// 回溯的判断条件：。
public class Solution037
{
    char[][] board;
    Node head;
    private class Node
    {
        public int number;
        public Node next;
    }
    public void solveSudoku(char[][] board)
    {
        this.head= new Node();
        Node cur = head;
        this.board = board;
        for(int i = 0;i<9;i++)
        {
            for(int j = 0; j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    cur.next = new Node();
                    cur.next.number = 9*i+j;
                    cur = cur.next;
                }
            }
        }
        solve(head.next);
    }
    private boolean solve(Node node)
    {
        //if(node==null && !isValidSudoku( ))
            //return false;
        //else
        if(node == null)
            return true;
        int row = node.number/9;
        int col = node.number - row*9;
        for( char i = '1';i<= '9';i++)
        {
            if(isValid(row,col,i))
            {
                board[row][col] = i;
                if (solve(node.next))
                    return true;
            }
        }
        board[row][col] = '.';
        return false;
    }

    public boolean isValid(int row, int col, char c)
    {
        for(int i = 0; i < 9; i++)
        {
            if (board[row][i]==c)
                return false;
            if(board[i][col]==c)
                return false;
            if(board[row/3*3+i/3][col/3*3+i%3]==c)
                return false;
        }
        return true;
    }

    public boolean isValidSudoku( )
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
    public void solveSudoku2(char[][] board) {
        this.board = board;
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid( i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

}
