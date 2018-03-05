package LeetCode051_100;

/**
 * Created by Tanya on 2017/10/10.
 */
public class Solution063
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        if(obstacleGrid == null||obstacleGrid.length==0)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
//        if(m==1 || n==1)
//            return 1;
        int [][]grid = new int[m][n];
        grid[0][0] = obstacleGrid[0][0] == 1?0:1;
        for(int j = 1; j <= n-1;j++)
        {
            if(obstacleGrid[0][j] == 1 || grid[0][j-1]==0)
                grid[0][j] = 0;
            else grid[0][j] = 1;

        }
        for(int i = 1;i<= m-1;i++)
        {
            if(obstacleGrid[i][0] == 1 || grid[i-1][0]==0)
                grid[i][0] = 0;
            else
                grid[i][0] = 1;
        }
        for(int i = 1;i<m;i++)
        {
            for (int j = 1;j<n;j++)
                if(obstacleGrid[i][j]==1)
                    grid[i][j] = 0;
                else
                    grid[i][j] = grid[i-1][j]+grid[i][j-1];
        }

        return grid[m-1][n-1];
    }
}
