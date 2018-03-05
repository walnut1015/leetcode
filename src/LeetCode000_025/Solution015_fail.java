package LeetCode000_025; /**
 * Created by Tanya on 2017/3/8.
 * 此题目标为实现正则表达式中的*和.
 * 一致拖着没有做，初时觉得简单，但是做起来却毫无头绪，这也是一直没有做的原因
 *
 */
import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.TreeMap;
        import  java.util.regex.*;
public class Solution015_fail {

    /*public boolean isMatch(String s, String p)
    {
        int ls = s.length(),lp = p.length();
        boolean [][]dp = new boolean [ls+1][lp+1];
        dp[0][0] = true;
        for(int i = 1;i<ls+1;i++)
        {
            for(int j =1;j<lp+1;j++)
            {

            }
        }
    }*/

    public List<List<Integer>> threeSum(int[] nums)
    {
        int len = nums.length; //健壮性！！
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(len==0) return lists;
        Arrays.sort(nums);
        int start = 0;
        int i1=0, cntzero =0;
        for(;i1<len && nums[i1]<=0 ;i1++)
            if(nums[i1]==0) cntzero++; //判断的先后顺序
        if(cntzero>=3)
        {
            List<Integer> templist = new LinkedList<Integer>();
            templist.add(0);templist.add(0);
            templist.add(0);
            lists.add(templist);
            return lists;
        }
        if(i1==len) return lists;
        int mid = start + i1 - 1;
        TreeMap<Integer, Integer> map1= new TreeMap<Integer,Integer>();
        for(int i =mid+1;i<len;i++) map1.put(nums[i],i);
        for(int i = start;i<=mid-1;i++)
        {
            //if(nums[i-1] == nums[i])
            for(int j =i+1;j<=mid;j++)
            {
                if(map1.containsKey(0-nums[i]-nums[j]))
                {
                    List<Integer> templist = new LinkedList<Integer>();
                    templist.add(nums[i]);templist.add(nums[j]);
                    templist.add(0-nums[i]-nums[j]);
                    lists.add(templist);
                }
                if(j<mid && nums[j]==nums[j+1]) j++;
            }
            if(i<mid && nums[i]==nums[i+1]) i++;
        }
        TreeMap<Integer, Integer> map2= new TreeMap<Integer,Integer>();
        for(int i =0;i<=mid;i++) map2.put(nums[i],i);
        for(int i = mid+1;i<len-1;i++)
        {
            for(int j =i+1;j<len;j++)
            {
                if(map2.containsKey(0-nums[i]-nums[j]))
                {
                    List<Integer> templist = new LinkedList<Integer>();
                    templist.add(nums[i]);templist.add(nums[j]);
                    templist.add(0-nums[i]-nums[j]);
                    lists.add(templist);
                }
                if(j<len-1 && nums[j]==nums[j+1]) j++;
            }
            if(i<len-1 && nums[i]==nums[i+1]) i++;
        }
        return lists;
    }

}