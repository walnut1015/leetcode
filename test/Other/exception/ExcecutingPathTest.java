package Other.exception;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * class: ExcecutingPathTest
 *
 * @author 刘天雅
 * @date 2018/03/05
 */
public class ExcecutingPathTest {

    @Test
    public void devideByZero() {
        ExcecutingPath ep = new ExcecutingPath();
        ep.devideByZero();
    }
}