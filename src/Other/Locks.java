package Other;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * @author tanya
 * @date 2018/8/20 20:00
 */
public class Locks {
    AbstractQueuedSynchronizer aqs;
    AtomicInteger ai;
    LockSupport ls;
}
