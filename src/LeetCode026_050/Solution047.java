package LeetCode026_050;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tanya on 2017/8/24.
 * 思路是先对数组进行排序，得到的是最小的排列，然后从大到小遍历，
 * 找到第一组顺序对（顺序对中小的为a,大的为b，索引分别为,i,i+1），
 * 在i+1~length-1中找到第一个大于a的数，与a交换位置，此时i+1~len-1
 * 位置的子数组呈倒排序，将此段的元素倒序便可，此时得到nextPermutation。
 * 注意点：
 * ①、放入list的元素对象，如果在之后的操作中还要对其进行修改值的操作，就new一个对象放入list吧。
 * ②、交换指定索引位置的元素操作用set()函数来。
 * ③、将i~length-1索引出的list的操作代码如下，希望以后能够借鉴：
 for(int j = 0; j <= (length-i)/2-1;j++)
 {
 int temp2 = curPermutation.get(i+j);
 curPermutation.set(i+j, curPermutation.get(length-1-j));
 curPermutation.set(length-1-j,temp2);
 }
 */
public class Solution047
{
    private int length;
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length==0)
            return res;
        this.length = nums.length;
        List<Integer> cur = new LinkedList<Integer>();
        Arrays.sort(nums);
        for(int a :nums)
            cur.add(a);
        res.add(new LinkedList<Integer>(cur));
        List<Integer> next = nextPermutation(cur);;
        while(next.size()!=0) //???具体返回什么形式的数据还有待考虑
        {
            res.add(new LinkedList<Integer>(next));
            cur = next;
            next = nextPermutation(cur);
        }
        return res;
    }
    private List<Integer> nextPermutation( List<Integer> curPermutation)
    {
        List<Integer> next = new LinkedList<>();
        for (int i = length-1;i>0;i--)
        {
            if(curPermutation.get(i-1)<curPermutation.get(i))
            {
                int temp = curPermutation.get(i-1);
                for(int j = length-1; j > i-1;j--)
                    if(curPermutation.get(j)>temp)
                    {
                        curPermutation.set(i-1,curPermutation.get(j));
                        curPermutation.set(j,temp);
                        break;
                    }
                for(int j = 0; j <= (length-i)/2-1;j++)
                {
                    int temp2 = curPermutation.get(i+j);
                    curPermutation.set(i+j, curPermutation.get(length-1-j));
                    curPermutation.set(length-1-j,temp2);
                }
                for(int a:curPermutation)
                    next.add(a);
                break;
            }
        }
        return next;
    }
}
