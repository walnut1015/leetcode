package LeetCode051_100;

/**
 * Created by Tanya on 2017/10/7.
 */
public class Solution059
{
    public int[][] generateMatrix(int n)
    {
        int[][] fill= new int[n][n];
        int index = 1;
        int left = 0, right = n-1;
        int up = 0, down = n-1;
        while(index<=n*n)
        {
            int rUp = left;
            while(rUp<=right)
            {
                fill[up][rUp] = index++;
                rUp++;
            }
            up++;
            int cRight = up;
            while(cRight<=down)
            {
                fill[cRight][right]=index++;
                cRight++;
            }
            right--;
            int rDown = right;
            while(rDown>=left)
            {
                fill[down][rDown] = index++;
                rDown--;
            }
            down--;
            int cLeft = down;
            while(cLeft>=up)
            {
                fill[cLeft][left] = index++;
                cLeft--;
            }
            left++;
        }
        return fill;
    }
}
