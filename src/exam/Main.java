package exam;

import java.util.*;

/**
 * @author tanya
 * @date 2018/5/22 10:57
 */
public class Main
{
/*    int k,d,n;
    int[] capabilities;
    public long chooseStudent(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        capabilities = new int[n+1];
        for(int i = 1;i<= n;i++){
            capabilities[i] = sc.nextInt();
        }
        k = sc.nextInt();
        d = sc.nextInt();
        long[][] dp = new long[k+1][n+1];
        long[][] mins = new long[k+1][n+1];
        for(int i = 1;i<n+1;i++){
            dp[1][i] = capabilities[i];
            mins[1][i] = capabilities[i];
        }
        for(int i = 2; i<k+1;i++){
            for(int j = i; j<n+1;j++){
                int cur = capabilities[j];
                long min = Integer.MAX_VALUE;
                long max = Integer.MIN_VALUE;
                    for(int m = j -1; m >= j-d && m>=i-1; m--){
                        max = Math.max(max,Math.max(cur*dp[i-1][m],cur*mins[i-1][m]));
                        min = Math.min(min,Math.min(cur*dp[i-1][m],cur*mins[i-1][m]));
                    }
                    dp[i][j] = max;
                    mins[i][j]=min;
            }
        }
        long res = dp[k][k];
        for(int i = k+1;i<n+1;i++){
            res = Math.max(res,dp[k][i]);
        }
        return res;
    }
    static public void main(String[] args){
        Main c = new Main();
        System.out.println(c.chooseStudent());
    }*/
/*    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line;
        Set<String> set = new HashSet<>();
        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            String[] strs = line.split(" ");
            for(String str:strs){
                if(str.length()>0){
                    set.add(str);
                }
            }
        }
        System.out.println(set.size());
    }*/

    /*static int[][] values;
    static int[][] sum;
    static int row,col;
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        values = new int[row][col];
        sum = new int[row][col];
        int total = 0;
        for(int  i = 0;i<row;i++){
                String str = scanner.next();
            for(int j = 0;j<col;j++){
                int value = str.charAt(j)-'0';
                values[i][j] = value;
                total += value;
                if(i==0 && j==0){
                    sum[i][j] = value;
                }
                else if(i==0){
                    sum[i][j] = value + sum[i][j-1];
                }
                else if(j==0){
                    sum[i][j] = value + sum[i-1][j];
                }
                else {
                    sum[i][j] = value - sum[i-1][j-1] + sum[i-1][j] + sum[i][j-1];
                }
            }
        }
        int low = 0,up = total/16;
        int mid;
        while (low<=up){
            mid = (low + up) / 2;
            if(largerThan(mid)){
                low = mid;
                if(low + 1 == up){
                    if(largerThan(up)){
                        System.out.println(up);
                        return;
                    }
                    System.out.println(low);
                    return;
                }
            }
            else {
                up = mid - 1;
            }
        }

    }

    static boolean largerThan(int value){
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE, third = Integer.MAX_VALUE;
        for(int i = 1;i<row;i++){
            for(int j = i+1;j<row;j++){
                for(int k = j+1;k<row;k++){
                    boolean yes1 = false;
                    boolean yes2 = false;
                    boolean yes3 = false;
                    for(first = 1; first<col;first++){
                        if(sum(0,i-1,0,first-1)>=value &&
                                sum(i,j-1,0,first-1) >= value &&
                                sum(j,k-1,0,first-1)>=value &&
                                sum(k,row-1,0,first-1)>=value){
                            yes1 = true;
                            break;
                        }
                    }
                    if (yes1){
                        for(second = first+1; second<col;second++){
                            if(sum(0,i-1,first,second-1)>=value &&
                                    sum(i,j-1,first,second-1) >= value &&
                                    sum(j,k-1,first,second-1)>=value &&
                                    sum(k,row-1,first,second-1)>=value){
                                yes2 = true;
                                break;
                            }
                        }
                    }
                    if(yes2){
                        for(third = second+1; third<col;third++){
                            if(sum(0,i-1,second,third-1)>=value &&
                                    sum(i,j-1,second,third-1) >= value &&
                                    sum(j,k-1,second,third-1)>=value &&
                                    sum(k,row-1,second,third-1)>=value){
                                yes3 = true;
                                break;
                            }
                        }
                    }

                    if(yes3){
                        if(sum(0,i-1,third,col-1)>=value &&
                                sum(i,j-1,third,col-1) >= value &&
                                sum(j,k-1,third,col-1)>=value &&
                                sum(k,row-1,third,col-1)>=value){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    static int sum(int up, int down, int left, int right){
        int res;
        if(up==0 && left ==0){
             res = sum[down][right];
        }
        else if(left == 0){
            res = sum[down][right] - sum[up-1][right];
        }
        else if(up == 0){
            res = sum[down][right] - sum[down][left -1];
        }
        else{
            res = sum[down][right] - sum[up-1][right]-sum[down][left-1] + sum[up-1][left-1];
        }
        return res;
    }*/

    /*分苹果*/
/*    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int cowsCnt = scanner.nextInt();
        int[] apples = new int[cowsCnt];
        boolean even = false, odd = false;
        int avgApple = 0, appleCnt = 0;
        for(int i = 0;i < cowsCnt;i++){
            int temp = scanner.nextInt();
            apples[i] = temp;
            appleCnt += temp;
            if(temp % 2 == 1){
                odd = true;
            }
            else {
                even = true;
            }
        }
        avgApple = appleCnt/cowsCnt;

        if(even && odd ||(avgApple*apples.length != appleCnt)){
            System.out.println(-1);
            return;
        }
        //List<Integer> withLessApples = new ArrayList<>();
        int differenceCnt = 0;
        for(int ele:apples){
            if(ele < avgApple){
                differenceCnt += avgApple-ele;
            }
        }
        System.out.println(differenceCnt/2);
    }*/
/*
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int row = t.length();
        int col = s.length();
        if(col == 0 || row>col){
            System.out.println("No");
            return;
        }
        boolean[][] isSubSequence = new boolean[t.length()][s.length()];
        for(int i = 0; i<col;i++){
            if(s.charAt(i)==t.charAt(0)){
                isSubSequence[0][i] = true;
            }
            else if(i>0){
                isSubSequence[0][i] = isSubSequence[0][i-1];
            }
            else{
                isSubSequence[0][i] = false;
            }
        }
        for(int j = 1; j<row;j++){
            isSubSequence[j][0] = false;
        }
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(isSubSequence[i][j-1]){
                    isSubSequence[i][j] = true;
                }
                else if(isSubSequence[i-1][j-1] && t.charAt(i)==s.charAt(j)){
                    isSubSequence[i][j] = true;
                }
                else{
                    isSubSequence[i][j] = false;
                }
            }
        }
        for(int i = row-1; i < s.length();i++){
            if(isSubSequence[row-1][i]){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
*/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] cost = new int[n];
        int[] value = new int[n];
        for(int i = 0;i<n;i++){
            cost[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        int[][] dp = new int[n][m+1];
        for(int i = 0; i<n;i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i<n;i++){
            for(int j = 1;j<m+1;j++){
                //花费的空间比总空间更大
                if(cost[i] > j ){
                    if(i>0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    else {
                        dp[i][j]=0;
                    }
                }

                else {
                    if(i==0){
                        dp[i][j] = value[i];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j-cost[i]]+value[i],dp[i-1][j]);
                    }
                }
            }
        }
        System.out.println(dp[n-1][m]);
    }
}
