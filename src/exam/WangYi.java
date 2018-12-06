package exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tanya
 * @date 2018/8/11 16:35
 */
public class WangYi {
    public static void main1(String[] ars)
    {
        int n = 0;
        int m = 0;
        int[] counts;
        int[] queries, copyQueries;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        counts = new int[n];
        for(int i = 0; i<n;i++){
            counts[i] = in.nextInt();
        }
        m = in.nextInt();
        queries = new int[m];
        copyQueries = new int[m];
        for(int i = 0; i<m;i++){
            queries[i] = in.nextInt();
            copyQueries[i] = queries[i];
        }
        Map<Integer,Integer> map = new HashMap<>();
        int[] totalCounts = new int[n];
        totalCounts[0] = counts[0];
        for(int i = 1;i < n;i++){
            totalCounts[i] = totalCounts[i-1]+counts[i];
        }
        Arrays.sort(copyQueries);
        int j = 0;
        for(int i = 0; i<n && j<m; i++){
            if(totalCounts[i] >= copyQueries[j]){
                map.put(copyQueries[j++], i);
            }
        }
        for(int i = 0; i < m;i++){
            System.out.println(map.get(queries[i])+1);
        }
        ConcurrentHashMap<String,String > mm;
        HashMap<String,String> mm2;
    }
}
