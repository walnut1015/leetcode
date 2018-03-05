package Other;

import java.util.*;

/**
 * class: SingletonCollection
 *
 * @author 刘天雅
 * @date 2018/02/21
 */
public class SingletonCollection
{
    public void singleton()
    {
        Set set = Collections.singleton("Dallas");
        set.add("New York");
    }
    public void orderSet()
    {
        Set set1 = new HashSet();
        set1.add("Dallas");
        set1.add("Apple");
        set1.add("Zip");

        Set set2 = new LinkedHashSet();
        set2.add("Dallas");
        set2.add("Apple");
        set2.add("Zip");

        Set set3 = new TreeSet();
        set3.add("Dallas");
        set3.add("Apple");
        set3.add("Zip");
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
    }
}
