import java.util.*;
public class Solution {
    public static void main(String[] args) {
        int creatorCap = 100;
        int numOfRadLiquid = 5;
        int criticalMass = 15;
        int[] volumes = {50,40,30,20,10};
        int[]messages = {1,2,3,9,5};
        int[] energies = {300, 480, 270, 200, 180};
        //System.out.println(backPack(creatorCap,volumes,energies));
        System.out.println(twoDimensionBackpack(creatorCap,volumes,energies,criticalMass,messages));
    }
    /**
     * 空间压缩版本的01背包问题解法
     */
    private static int backPack(int backPackCap,int[] volums, int[] values){
        int len = values.length;
        int[] dp = new int[backPackCap+1];
        dp[0] = 0;
        for(int i = 0; i<len;i++){
            dp[i] = volums[0]<=i?values[0]:0;
        }
        for(int i = 1; i < volums.length;i++){
            for(int j = backPackCap; j >= 1;j--){
                if(volums[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - volums[i]] + values[i]);
                }
            }
        }
        return dp[backPackCap];
    }
    /**
     * 二维背包问题的空间压缩版本解法
     */
    private static int twoDimensionBackpack(int backPackCap,int[] volums, int[] values,int criticalMass, int[] masses){
        int[][] dp = new int[backPackCap+1][criticalMass+1];
        for(int i = 1; i<=backPackCap;i++){
            for(int j = 1;j<=criticalMass; j++){
                if(volums[0]<= i && masses[0]<= j){
                    dp[i][j] = values[0];
                }
            }
        }
        for(int i = 1; i<values.length;i++){
            for(int j = backPackCap; j>=1; j--){
                for(int k = criticalMass; k>=1;k--){
                    if(volums[i]<= j && masses[i] <= k){
                        dp[j][k] = Math.max(dp[j][k],dp[j-volums[i]][k-masses[i]] + values[i]);
                    }
                }
            }
        }
        return dp[backPackCap][criticalMass];
    }
}
