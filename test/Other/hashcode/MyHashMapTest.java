package Other.hashcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * class: MyHashMapTest
 *
 * @author 刘天雅
 * @date 2018/02/28
 */
public class MyHashMapTest {
    @Test
    public void main()
    {
/*        MyMap<String, String> map = new MyHashMap<>();
        map.put("Tanya","23");
        map.put("Tom","25");
        map.put("Maria","50");
        map.put("John","51");
        System.out.println("map中的内容有："+map);
        map.remove("Maria");
        System.out.println("map中的内容有："+map);
        System.out.println("Tanya的年龄为"+map.get("Tanya"));
        System.out.println("map中存在John吗？---->"+map.containsKey("John"));
        map.clear();
        System.out.println("map中的内容有："+map);*/

//        Set<Entry<String,String>> set = new HashSet<>();
//        set.add(new Entry<String, String>("Tanya","23"));
        Entry<String,String>[] set = new Entry[3];
        for(int i = 0;i<set.length;i++)
            set[i] = new Entry<>("Tanya","23");
        for(Entry entry:set)
            //entry = new Entry("Tanya","100"); //×
            entry.setValue("100"); //√
        System.out.println(set);
    }
    @Test
    public void testClear() throws Exception
    {
        MyHashMap<String,String> hasmap = new MyHashMap<>();
        hasmap.clear();
    }

    @Test
    public void testContainsKey() throws Exception {

    }

    @Test
    public void testContainsValue() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testPut() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testEntrySet() throws Exception {

    }

    @Test
    public void testKeySet() throws Exception {

    }

    @Test
    public void testValues() throws Exception {

    }
}