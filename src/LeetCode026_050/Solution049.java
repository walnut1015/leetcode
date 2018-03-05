package LeetCode026_050;

import java.util.*;

/**
 * Created by Tanya on 2017/9/10.
 * 自己的方法是先将每一个字符串都排序，然后用一个新的数组保存，
 * 一次将字符串存入map<String ,int>中，int表示最后生成的List<List<String>>中这个String对应的索引
 * ,存完之后再遍历字符串数组将map中的信息存入字符串-----该方法超时
 *我参考的方法和我的方法思想类似，但是没有超时，两种方法时间复杂度都是 O(n*m*log(m))
 *原因可能是因为我的做法遍历了strs数组好几遍。
 */
public class Solution049
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> res = new LinkedList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(int i = 0;i<strs.length;i++)
        {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if(map.get(temp)==null)
                map.put(temp,new LinkedList<String>());
            map.get(temp).add(strs[i]);
        }
//        for(String key:map.keySet())
//        {
//            res.add(map.get(key));
//        }
        return new LinkedList(map.values()); //生成返回结果的简便做法。
    }

    public List<List<String>> groupAnagrams2(String[] strs)
    {
        List<List<String>> res = new LinkedList<>();
        String [] newStrs = new String[strs.length];
         for(int i = 0;i<strs.length;i++)
        {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            newStrs[i] = new String(chars);
        }
        Map<String,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0;i<strs.length;i++)
        {
            if(map.get(newStrs[i])==null)
            {
                map.put(newStrs[i],count++);
            }
        }
        for(int i = 0;i<map.size();i++)
        {
            List<String> ele = new LinkedList<>();
            res.add(ele);
        }
        for(int i = 0;i<strs.length;i++)
        {
            res.get(map.get(newStrs[i])).add(strs[i]);
        }
        return res;
    }
}
