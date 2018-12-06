package exam.zhenti;

import java.util.*;

/**
 * @author tanya
 * @date 2018/8/23 16:47
 */
public class Solution {
    private static int[] balls;
    private static int numOfOnes;
    private static int ballCnt;
    private static HashMap<Integer,Integer> map;
    private static List<Integer> uniqNums= new ArrayList<>();
    /**
     * 混合颜料
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ballCnt = in.nextInt();
        balls = new int[ballCnt];
        numOfOnes = 0;
        map = new HashMap<>();
        for(int i = 0; i < ballCnt; i++){
            int temp = in.nextInt();
            if(temp==1){
                numOfOnes++;
            }
            balls[i] = temp;
            if(!map.containsKey(temp)){
                uniqNums.add(temp);
                map.put(temp, 1);
            }
            else {
                map.put(temp,map.get(temp)+1);
            }
        }
        if(ballCnt<1 || balls[0] != 1){
            return;
        }
        map.put(1,map.get(1)-1);
        Arrays.sort(balls);
        int res = luckyPockets(0,1,1);
        System.out.println(res);
    }
    private static int luckyPockets(int start , int curSum, int curMultiplyRes){
        if(start >= uniqNums.size()){
            return 0;
        }
        int num = uniqNums.get(start);
        int res = 0;
        //考虑不保留第start个数字对应的球球的情况
        res += luckyPockets(start+1, curSum, curMultiplyRes);
        int tempMultiRes = 1;
        for(int i = 1; i <= map.get(num);i++){
            tempMultiRes *= num;
            int multiplyRes = curMultiplyRes *  tempMultiRes;
            if(curSum + num*i < multiplyRes){
                break;
            }
            res += 1;
            res += luckyPockets(start+1,curSum + num*i ,multiplyRes);
        }
        return res;
    }


}
