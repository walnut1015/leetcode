package Other.hashcode;

import java.util.Set;

/**
 * class: MyMap
 *
 * @author 刘天雅
 * @date 2018/02/27
 */
public interface MyMap<K,V>
{
    public void clear();

    public  boolean containsKey(K key);
    public boolean containsValue(V value);

    public V get(K key);
    public V put(K key, V value);
    public void remove(K key);

    public boolean isEmpty();
    public int size();

    public Set<Entry<K,V>> entrySet();
    public Set<K> keySet();
    public Set<V> values();

}
