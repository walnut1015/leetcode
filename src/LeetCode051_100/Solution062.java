package LeetCode051_100;

/**
 * Created by Tanya on 2017/10/10.
 */
public class Solution062
{
    public int uniquePaths(int m, int n)
    {
        if(m==1 || n==1)
            return 1;
        int [][]grid = new int[m][n];
        for(int j = 0;j<n;j++)
            grid[0][j] = 1;
        for(int i = 0;i<m;i++)
            grid[i][0] = 1;
        for(int i = 1;i<m;i++)
        {
            for(int j = 1;j<n;j++)
            {
                grid[i][j] = grid[i-1][j]+grid[i][j-1];
            }
        }

        return grid[m-1][n-1];
    }
}
