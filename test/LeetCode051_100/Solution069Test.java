package LeetCode051_100;

import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;

import static org.junit.Assert.*;

/**
 * class: Solution069Test
 *
 * @author 刘天雅
 * @date 2018/03/06
 */
public class Solution069Test {

    @Test
    public void mySqrt()
    {
        Solution069 sol = new Solution069();
        int errorCount =0;
        for(int i = 0;i<500;i++)
        {
            if((int)(Math.sqrt(i))!=sol.mySqrt(i)) {
                System.out.println("有问题哦  " + i+"  正确："+(int)(Math.sqrt(i))+ "；  错误："+sol.mySqrt(i));
                errorCount++;
            }

            //System.out.println("输入："+i);
        }
        System.out.println(errorCount+"个错误出现");
    }
}