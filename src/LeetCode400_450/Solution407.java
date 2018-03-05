package LeetCode400_450;

import java.util.Arrays;

/**
 * Created by Tanya on 2017/8/15.
 */
public class Solution407
{
//    public void test()
//    {
//        int [][]a= {
//                {1,4,3,1,3,2},
//                {3,2,1,3,2,4},
//                {2,3,3,2,3,1}
//            };
//        int [][]b = System.arraycopy();
//    }
    int [][]heightMap;
    public int trapRainWater(int[][] heightMap)
    {
        int row = heightMap.length;
        if(heightMap==null || row<3)
            return 0;
        int col = heightMap[0].length;
        if(col<3)
            return 0;
        this.heightMap= heightMap;
        int vol = 0;
        int[][] snglWaterHght = new int[row][col];
        for(int j = 1; j<col-1;j++)
        {
            int lo = 1, hi = row-2;
            int leftH = heightMap[0][j],rightH = heightMap[row-1][j];
            while(!(lo > hi))
            {
                if(heightMap[lo-1][j]<heightMap[hi+1][j])
                {
                    leftH = Math.max(leftH,heightMap[lo][j]);
                    snglWaterHght[lo][j] = leftH-heightMap[lo][j];
                    lo++;
                }
                else
                {
                    rightH = Math.max(rightH,heightMap[lo][j]);
                    snglWaterHght[hi][j] = rightH-heightMap[hi][j];///????有必要吗
                    hi--;
                }
            }
        }
        for(int i = 1;i< row-1;i++)
        {
            if(snglWaterHght[i][1]+heightMap[i][1]<= heightMap[i][0])
            {
                for(int j = i-1;j>1 && snglWaterHght[j][1]+heightMap[j][1]==snglWaterHght[i][1]+heightMap[i][1];j--)
                    snglWaterHght[j][1]=0;
                for(int j = i-1;j<row-1 && snglWaterHght[j][1]+heightMap[j][1]==snglWaterHght[i][1]+heightMap[i][1];j++)
                    snglWaterHght[j][1]=0;
                snglWaterHght[i][1]=0;
            }
            if(snglWaterHght[row-1-i][1]+heightMap[row-1-i][1]<= heightMap[row-1-i][0])
            {
                for(int j = i-1;j>1 && snglWaterHght[j][1]+heightMap[j][1]==snglWaterHght[i][1]+heightMap[i][1];j--)
                    snglWaterHght[j][1]=0;
                for(int j = i-1;j<row-1 && snglWaterHght[j][1]+heightMap[j][1]==snglWaterHght[i][1]+heightMap[i][1];j++)
                    snglWaterHght[j][1]=0;
                snglWaterHght[i][1]=0;
            }

        }
        for(int i = 0;i<row;i++)
        {
            for(int j = 0; j <col;j++)
            {
                System.out.print(snglWaterHght[i][j]+"\t");
            }
            System.out.println();
        }
        boolean [][]fixed = new boolean[row][col];
        for(int i =0;i<row;i++)
        {
            Arrays.fill(fixed[i],false);
            fixed[i][0] = true;
            fixed[row-1-i][col-1] = true;
        }
        for(int j =1;j<col-1;j++)
        {
            fixed[0][j] = true;
            fixed[row-1][j] = true;
        }
        for(int i = 0;i<row;i++)
        {
            for(int j = 0; j <col;j++)
            {
                if(!fixed[i][j] && snglWaterHght[i][j]!=0) {
                    int lowestLv = unifyWaterLevel(snglWaterHght, i, j);
                    setWaterLevel(snglWaterHght,i,j,lowestLv,fixed);
                }
            }
        }
        for(int i = 0;i<row;i++)
        {
            for(int j = 0; j <col;j++)
            {
                if(fixed[i][j]) {
                    vol+=snglWaterHght[i][j];
                }
            }
        }

        return vol;
    }
    private int unifyWaterLevel(int[][] snglWaterHght, int i , int j)
    {
        //if(snglWaterHght[i][])
        //int newLowest = Integer.MAX_VALUE;
        for(int m = i; snglWaterHght[m][j] != 0;m++)
        {
            if(snglWaterHght[m][j+1] != 0)
            {
                return Math.min(snglWaterHght[m][j]+heightMap[m][j], unifyWaterLevel(snglWaterHght,m,j+1));
            }
            else
                return snglWaterHght[m][j]+heightMap[m][j];
        }
        for(int m = i; snglWaterHght[m][j] != 0;m--)
        {
            if(snglWaterHght[m][j+1] != 0)
            {
                return Math.min(snglWaterHght[m][j]+heightMap[m][j], unifyWaterLevel(snglWaterHght,m,j+1));
            }
            else
                return snglWaterHght[m][j]+heightMap[m][j];
        }
        return snglWaterHght[i][j]+heightMap[i][j];
    }
    private void setWaterLevel(int[][] snglWaterHght, int i, int j, int level,boolean[][] fixed) {
        for (int m = i; snglWaterHght[m][j] != 0; m++) {
            if (snglWaterHght[m][j + 1] != 0) {
                if (heightMap[m][j] > level)
                    snglWaterHght[m][j] = 0;
                else
                    snglWaterHght[m][j] = level - heightMap[m][j];
                fixed[m][j] = true;
                setWaterLevel(snglWaterHght, i, j + 1, level, fixed);
            } else {
                if (heightMap[m][j] > level)
                    snglWaterHght[m][j] = 0;
                else
                    snglWaterHght[m][j] = level - heightMap[m][j];
                fixed[m][j] = true;
                setWaterLevel(snglWaterHght, i, j + 1, level, fixed);
                return;
            }
        }
        for (int m = i; snglWaterHght[m][j] != 0; m--) {
            if (snglWaterHght[m][j + 1] != 0) {
                if (heightMap[m][j] > level)
                    snglWaterHght[m][j] = 0;
                else
                    snglWaterHght[m][j] = level - heightMap[m][j];
                fixed[m][j] = true;
                setWaterLevel(snglWaterHght, i, j + 1, level, fixed);
            } else {
                if (heightMap[m][j] > level)
                    snglWaterHght[m][j] = 0;
                else
                    snglWaterHght[m][j] = level - heightMap[m][j];
                fixed[m][j] = true;
                setWaterLevel(snglWaterHght, i, j + 1, level, fixed);
                return;
            }
        }
    }
}
