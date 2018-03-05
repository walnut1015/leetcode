package LeetCode000_025;

/**
 * Created by Tanya on 2017/3/2.
 * 对于可能的输入，缺乏周全的预期考虑。没考虑到的场景有：
 * “         +12”，“1232u32”,超长度的溢出，还试图通过初始的字符串长度来判断是否溢出。
 * *
 */
public class Solution008 {
    public static void mains(String []args)
    {
        Solution008 s = new Solution008();
        System.out.print(s.myAtoi("             -9223372036854775809"));
    }
    public int myAtoi(String str)
    {
        long res = 0;
        if(str == null || str.length()==0) return 0;
        int len = str.length(),symbol = 1,k = 0,flag=0;
        char []chars = new char[len];
        for(int i =0;i<len;i++) chars[i] = str.charAt(i);
        while(chars[k]==' '&& k<len) k++;
        if(chars[k] == '-' || chars[k] == '+'){
            symbol = (chars[k]=='+')?1:-1;
            k ++;
        }
        for(;k<len;k++) {
            if(chars[k]<'0'|| chars[k]>'9') break;
            res = 10*res + chars[k]-'0';
            flag++;
        }
        if(flag>11){
            if(symbol==-1) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        res *= symbol;
        if(res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)res;
    }
}
