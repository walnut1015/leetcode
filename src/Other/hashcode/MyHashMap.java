package Other.hashcode;

import org.omg.CORBA.PRIVATE_MEMBER;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * class: MyHashMap
 *
 * @author 刘天雅
 * @date 2018/02/27
 */
public class MyHashMap<K,V> implements MyMap<K,V>
{
    private static int DEFAULT_CAPACITY = 4; //???为什么要static;为什么是2的幂次方
    private static float DEFAULT_LOAD_FACTOR = 0.75f;
    private static int MAX_CAPACITY = 1<<30;

    private int capacity;
    private float loadFactor;

    LinkedList<Entry<K,V>> [] mapLists;
    int size = 0;
    public MyHashMap()
    {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);//使用this()来调用自身的其它构造函数，super()调用父类的构造函数。
    }
    public MyHashMap(float loadFactor)
    {
/*        if(loadFactor >0) //构造函数必须位于方法的第一行，而且不能重复调用；
            //MyHashMap(DEFAULT_CAPACITY, loadFactor);
            this(DEFAULT_CAPACITY, loadFactor);
        else this();*/
        this(DEFAULT_CAPACITY, loadFactor);
    }
    public  MyHashMap(int maxCapacity, float loadFactor)
    {
        if(loadFactor>0)
            this.loadFactor = loadFactor;
        else
            this.loadFactor = DEFAULT_LOAD_FACTOR;
        if(maxCapacity > MAX_CAPACITY)
            capacity = MAX_CAPACITY;
        else
            capacity = maxCapacity;
        mapLists = new LinkedList[capacity];
        for(int i=0; i<mapLists.length;i++)
            mapLists[i] = new LinkedList<>();
        System.out.println(mapLists);
    }

    @Override
    public void clear()
    {
        for(LinkedList<Entry<K,V>> list:mapLists)
        {
            if(list!=null) {
                Iterator<Entry<K, V>> iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
            }
        }
        size = 0;
    }

    @Override
    public boolean containsKey(K key) { //应该充分考虑到类之间代码的复用
        int index = hash(key.hashCode());
        if(mapLists[index]!= null) {
            for (Entry<K, V> entry : mapLists[index])
                if (entry.getKey().equals(key))
                    return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for(LinkedList<Entry<K,V>> list:mapLists)
            if(list!=null) {
                for (Entry<K, V> entry : list)
                    if (entry.getValue().equals(value))
                        return true;
            }
        return false;
    }

    @Override
    public V get(K key) {
/*        if(mapLists[index].size()==0)
            return null;
        else
        {*/
        if(containsKey(key)==true){
            int index = hash(key.hashCode());
            for(Entry<K,V> entry:mapLists[index])
                if(entry.getKey().equals(key))
                    return entry.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = hash(key.hashCode());
        V oldValue = null;
        if(containsKey(key)) {
            for (Entry<K, V> entry : mapLists[index]) {
                if (entry.getKey().equals(key)) {
                    oldValue = entry.getValue();
                    entry.setValue(value);
                }
            }
        }
        else
        {
            oldValue = null;
            mapLists[index].add(new Entry(key,value));
            size++;
        }
        //如果当前的size超出了装载因子*容量，则将所有的entry都移到扩大的hashMap中去；
        if(loadFactor*capacity < size)
            try {
                rehash();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return oldValue;
    }

    @Override
    public void remove(K key) {
        if(containsKey(key)) {
            int index = hash(key.hashCode());
            Iterator<Entry<K, V>> iterator = mapLists[index].iterator();
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                if (entry.getKey().equals(key)) {
                    iterator.remove();
                    size--;
                    break;//
                }
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0?true:false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        //把Entry对象放到Set中去，是不是还要覆写Entry的hashCode()方法，或者覆写equals方法？hashCode默认为
        Set<Entry<K, V>> set = new HashSet<>();
        for(LinkedList<Entry<K,V>> list:mapLists)
            if(list!=null) {
                for (Entry<K, V> entry : list)
                    set.add(entry);
            }
        return set;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Set<V> values() {
        return null;
    }

    private int hash(int hashCode)
    {
        //return supplementalHash(hashCode)^(capacity-1); //more efficient than supplementalHash(hashCode)%capacity;
        return supplementalHash(hashCode)%capacity;
    }

    private int supplementalHash(int h)
    {
        h ^= (h>>>12)^(h>>>20);
        return h^(h>>>7)^(h>>>4);
    }

    private void rehash() throws Exception
    {
        if(capacity <<1 < MAX_CAPACITY)
        {
            Set<Entry<K,V>> set = entrySet();
            capacity <<= 1;
            clear();
            mapLists = new LinkedList[capacity];
            for(int i = 0;i<mapLists.length;i++)
                mapLists[i] = new LinkedList<>();
            for(Entry<K,V> entry:set)
            {
                put(entry.getKey(), entry.getValue());
            }
        }
        else
            throw new Exception("映射表超出容量！");//Is this appropriate? RuntimeException、Exception
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Set<Entry<K,V>> entries = entrySet();
        for(Entry<K,V> entry: entries)
        {
            sb.append("["+entry.getKey()+":"+entry.getValue()+"] ");
        }
        return sb.toString();
    }
}
