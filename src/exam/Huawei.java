package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tanya
 * @date 2018/8/8 18:59
 */
public class Huawei {
    public static void main1(String[] args) {
        StringBuilder inputSb = new StringBuilder();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            inputSb.append(in.nextLine());
        }
        char[] input = inputSb.toString().toCharArray();
        for(int i = 0;i<input.length;i++){
            char temp = input[i];
            if(temp >='A' && temp <= 'Z'){
                input[i] = (char)(temp + 32);
            }
            else if(temp >='a' && temp <= 'z'){
                input[i] = (char)(temp - 32);
            }
        }
        System.out.println(new String(input));
    }


    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String valueStr = in.nextLine();
        String weightStr = in.nextLine();
        int[] values = new int[5];
        int[] weights = new int[5];
        int capacity;
        int i = 0;
        for(String str: valueStr.split(",")){
            values[i++] = Integer.parseInt(str);
        }
        i = 0;
        for(String str: weightStr.split(",")){
            weights[i++] = Integer.parseInt(str);
        }
        capacity = in.nextInt();
        int[][] dp = new int[5][capacity+1];
        for(int m = 0; m<5;m++){
            dp[m][0] = 0;
        }
        for(int m = 0; m< values.length;m++){
            for(int j = 1; j<capacity+1;j++){
                if(weights[m]>j){
                    if( m >0 ) {
                        dp[m][j] = dp[m - 1][j];
                    }
                    else {
                        dp[m][j] = 0;
                    }
                }
                else{
                    if(m == 0){
                        dp[m][j] = values[m];
                    }
                    else {
                        dp[m][j] = Math.max(dp[m - 1][j - weights[m]] + values[m], dp[m - 1][j]);
                    }
                }
            }
        }
        System.out.println(dp[4][capacity]);
    }
    private static Map<String,String> convertMap = new HashMap<>();
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        String typedefs = in.nextLine();
        String input = in.nextLine();
        //将所有的可替换的字符串对存入map中
        String [] typedefStrs = typedefs.split(";");

        for(String str: typedefStrs){
            /*String[] temp = str.trim().split(" ");
            convertMap.put(temp[2],temp[1]);*/
            str = str.trim();
            int start = str.indexOf(" ");
            int end = str.lastIndexOf(" ");
            convertMap.put(str.substring(end+1, str.length()),str.substring(start+1, end));
        }
        boolean flag;
        do{
            flag = false;
            for(Map.Entry<String,String> entry: convertMap.entrySet()){
                String newStr;
                if((newStr = replace(input, entry.getKey(), entry.getValue()))!=null){
                    input = newStr;
                    flag = true;
                    break;
                }
            }
        }while (flag);
        String res = input;
        res = res.replaceAll("\\*"," \\*");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<res.length()-1;i++){
            if(res.charAt(i) == ' ' && res.charAt(i+1)==' '){
                continue;
            }
            sb.append(res.charAt(i));
        }
        if(!(res.charAt(res.length()-2) == ' ' && res.charAt(res.length()-1) == ' ')){
            sb.append(res.charAt(res.length()-1));
        }
        System.out.println(sb.toString());
    }
    public static String replace(String input, String target, String newStr){
        if(input.contains(target) && input.indexOf(target) == 0){
            if(target.length()<input.length() && input.charAt(target.length()) != '*' && input.charAt(target.length())!=' '){
                return null;
            }
            return input.replaceFirst(target, newStr);
        }
        return null;
    }
}
