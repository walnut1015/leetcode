package exam;
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        int[] arr={1,2,4,3,3,3,4,2,5,5,5,5,6,6,6,7,8,9,10};
        int num = 19;
        List a = new Main2().salaryfrequency(num,arr);
        System.out.println(a);
    }
    public List salaryfrequency(int len, int[] arr) {
        int num = len;
        int[] salaries = arr;
        Map<Integer,Integer> occurrences = new HashMap<>();
        for(int i = 0;i<num;i++){
            int temp = salaries[i];
            salaries[i] = temp;
            if(occurrences.containsKey(temp)){
                occurrences.put(temp,occurrences.get(temp)+1);
            }
            else {
                occurrences.put(temp,1);
            }
        }
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(Integer key: occurrences.keySet()){
            int value = occurrences.get(key);
            if(map.containsKey(value)){
                map.get(value).add(key);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(key);
                map.put(value,list);
            }
            set.add(value);
        }
        Integer[] occurenceNum = new Integer[set.size()];
        int k = 0;
        for(Integer intele:set){
            occurenceNum[k++] = intele;
        }
        Arrays.sort(occurenceNum, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        ArrayList<Integer> res = new ArrayList<>();
        for(int occurence :occurenceNum){
            ArrayList<Integer> eles = map.get(occurence);
            for(int ele:eles){
                for(int j = 0;j<occurence;j++){
                    res.add(ele);
                }
            }
        }
        return res;
    }
}
