package LeetCode051_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 2017/9/14.
 */
public class Solution054
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> res = new ArrayList<>();
        if(matrix==null||matrix.length==0 )
            return res;
        if(matrix.length==0)
        {
            for(int a:matrix[0])
            res.add(a);
            return res;
        }
        if(matrix[0].length==1)
        {
            for(int i = 0;i<matrix.length;i++)
            {
                res.add(matrix[i][0]);
            }
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        res.add(matrix[0][0]);
        matrix[0][0]=Integer.MAX_VALUE;
        int i = 0, j = 0;
        for(int k = 1;k<row*col;k++) //意思是上一个确定在螺旋轨迹上的点是matrix[i][j]
        {
            if((j<col-1 && matrix[i][j+1]!=Integer.MAX_VALUE )) //右方能走
            {
                if( i<row-1 && matrix[i+1][j]!=Integer.MAX_VALUE) //右下能走，走右
                {
                    res.add(matrix[i][1+j]);
                    matrix[i][++j] = Integer.MAX_VALUE;
                }
                else if(i>0 && matrix[i-1][j]!=Integer.MAX_VALUE)//右上能走，走上
                {
                    res.add(matrix[i-1][j]);
                    matrix[--i][j] = Integer.MAX_VALUE;
                }
                else //右方能走，上下都不能走，说明从左边来，此时只能向右走；
                {
                    res.add(matrix[i][1+j]);
                    matrix[i][++j] = Integer.MAX_VALUE;
                }
            }
            else if(j>0 && matrix[i][j-1]!=Integer.MAX_VALUE )//左方能走
            {
                if( i<row-1 && matrix[i+1][j]!=Integer.MAX_VALUE) //左下能走，走下
                {
                    res.add(matrix[1+i][j]);
                    matrix[++i][j] = Integer.MAX_VALUE;
                }
                else if(i>0 && matrix[i-1][j]!=Integer.MAX_VALUE)//左上能走，走左
                {
                    res.add(matrix[i][j-1]);
                    matrix[i][--j] = Integer.MAX_VALUE;
                }
                else //左方能走，上下都不能走，说明从右方来，此时只能向所左走；
                {

                    res.add(matrix[i][j-1]);
                    matrix[i][--j] = Integer.MAX_VALUE;
                }
            }
            else if( i<row-1 && matrix[i+1][j]!=Integer.MAX_VALUE)//只有下方能走，走下方。
            {
                res.add(matrix[i+1][j]);
                matrix[++i][j] = Integer.MAX_VALUE;
            }
            else if(i>0 && matrix[i-1][j]!=Integer.MAX_VALUE)//只有上方能走，走上方。
            {
                res.add(matrix[i-1][j]);
                matrix[--i][j] = Integer.MAX_VALUE;
            }
            else continue;
        }
        return res;
    }
}
