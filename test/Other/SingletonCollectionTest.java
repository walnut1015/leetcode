package Other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * class: SingletonCollectionTest
 *
 * @author 刘天雅
 * @date 2018/02/21
 */
public class SingletonCollectionTest {

    @Test
    public void testSingleton() throws Exception {
        SingletonCollection sc = new SingletonCollection();
        sc.singleton();
    }
    @Test
    public void testOrderSet()  {
        SingletonCollection sc = new SingletonCollection();
        sc.orderSet();
    }
}