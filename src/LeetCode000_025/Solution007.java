package LeetCode000_025;

/**
 * Created by Tanya on 2017/2/28.
 * 比较有意思的是对溢出的判断。
 */
public class Solution007 {
    public static void mains(String []args)
    {
        Solution007 s = new Solution007();
        System.out.print(s.reverse(1534236469));
    }
    public int reverse(int x)
    {
        if(x ==0) return 0;
        long resnum=0;
        int symbol = x/Math.abs(x);
        int absx = Math.abs(x);
        while(absx!=0)
        {
            resnum = (absx%10) + resnum*10;
            absx/=10;
        }
        resnum = resnum*symbol;
        if(resnum>Integer.MAX_VALUE || resnum<Integer.MIN_VALUE) return 0;
        return (int)resnum;
    }
    public String convert(String s, int numRows)
    {
        String resstr = new String();
        int len = s.length();
        char []chars = new char[len];
        int unitnum = 2*numRows-2;
        int unitcount = (len%unitnum==0)?(len/unitnum):(len/unitnum+1);
        for(int i = 0;i<len;i++)
        {
            int horizdis = i/unitnum;
            int verticdis = i % unitnum;
            int extra = 0;
            if(verticdis >= unitnum/2) extra = 1;
            int index = unitcount + 2*(verticdis-1)*unitcount + 2*horizdis + extra;
            chars[index] = s.charAt(i);
        }
        return resstr;
    }
}
