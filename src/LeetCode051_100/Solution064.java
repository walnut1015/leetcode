package LeetCode051_100;

/**
 * Created by Tanya on 2017/10/16.
 */
public class Solution064
{
    public int minPathSum(int[][] grid)
    {
        if(grid == null || grid.length==0 || grid[0].length==0)
            return 0;
        int []minSum = new int[grid[0].length];
        int row = grid.length, col = grid[0].length;
        minSum[0] = 0;
        for(int i = 0;i<row;i++)
        {
            for (int j = 0;j<col;j++)
            {
                if(j==0)
                    minSum[j] = minSum[j] + grid[i][j];
                else if(i==0)
                    minSum[j] = minSum[j-1] + grid[i][j];
                else
                    minSum[j] = grid[i][j] + Math.min(minSum[j],minSum[j-1]);
            }
        }
        return minSum[col-1];
    }
}
