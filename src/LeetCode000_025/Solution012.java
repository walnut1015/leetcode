package LeetCode000_025;

/**
 * Created by Tanya on 2017/3/12.
 * 数组可以解决的问题居然尽想着用循环，函数，真是蠢蠢蠢，唉
 */
public class Solution012 {
    public String intToRoman(int num)
    {
        String []m={"","M","MM","MMM"};
        String []c={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String []x={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String []i={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return m[num/1000]+c[num%1000/100]+x[num%100/10]+i[num%10];
    }
    public String myintToRoman(int num)
    {
        if(num<0 || num>3999) return "";
        int num2=num;
        String str = "";
        int base = 1;
        while (num2/10 !=0) {
            base*=10;
            num2/=10;
        }
        num2 = num;
        while(base!=0)
        {
            int temp = num2/base;
            if(temp<4)
            {
                while(temp-->0)
                    str=str.concat(trans2RomChar(base));
            }
            if(temp==4)
            {
                str=str.concat(trans2RomChar(base)).concat(trans2RomChar(base*5));
            }
            if(temp==5)
            {
                str=str.concat(trans2RomChar(base*5));
            }
            if(temp>5 && temp<9)
            {
                str=str.concat(trans2RomChar(base*5));
                temp-=5;
                while (temp-- > 0)
                    str=str.concat(trans2RomChar(base));
            }
            if(temp == 9)
                str=str.concat(trans2RomChar(base)).concat(trans2RomChar(base*10));
            num2%=base;
            base /=10;
        }
        return str;
    }
    public String trans2RomChar(int input)
    {
        switch (input)
        {
            case 1: return "I";
            case 5: return "V";
            case 10: return "X";
            case 50: return "L";
            case 100: return "C";
            case 500: return "D";
            case 1000: return "M";
            default: return null;
        }
    }
}
