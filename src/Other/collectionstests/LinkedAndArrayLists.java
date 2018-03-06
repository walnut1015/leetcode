package Other.collectionstests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * class: LinkedAndArrayLists
 *
 * @author 刘天雅
 * @date 2018/03/06
 */
public class LinkedAndArrayLists
{
    public void insertAtEnd()
    {
        int size = 5000000;
        long start = System.currentTimeMillis();
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0;i<size;i++)
        {
            list1.add(i);
        }
        System.out.println("ArrayList费时间："+(System.currentTimeMillis()-start) +"秒");
        start = System.currentTimeMillis();
        List<Integer> list2 = new LinkedList<>();
        for(int i = 0;i<size;i++)
        {
            list2.add(i);
        }
        System.out.println("LinkedList费时间："+(System.currentTimeMillis()-start) +"秒");
    }
}
