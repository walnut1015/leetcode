package LeetCode026_050;

/**
 * Created by Tanya on 2017/9/10.
 */
public class Solution048
{
    public void rotate(int[][] matrix)
    {
        if(matrix == null || matrix.length==0 || matrix.length==1)
            return;
        int len = matrix.length;
        for(int i = 0;i<len/2;i++)
        {
            for(int j =i;j<len-i-1; j++)
            {
                int temp1 = matrix[i][j];
                int temp2 = matrix[j][len-1-i];
                matrix[j][len-1-i] = temp1;
                temp1 = temp2;
                temp2 = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = temp1;
                temp1 = temp2;
                temp2 = matrix[len-1-j][i];
                matrix[len-1-j][i] = temp1;
                temp1 = temp2;
                matrix[i][j] = temp1;
            }
        }
    }
}
