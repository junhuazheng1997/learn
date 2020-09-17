package thread.lock.demo;

import java.time.LocalDateTime;

/**
 * @author kris
 * @since 2020-09-14
 */
public class LockType {

    /**
     * 测试单例与非单例情况锁的区别
     */
    public static volatile int lock = 0;

    public synchronized void testLockType() throws InterruptedException {
        Thread.sleep(1000);
//        lock++;
        System.out.println("同步方法被调用: " + LocalDateTime.now() + "--------" + "当前线程为: "
                + Thread.currentThread().getName()/* + "----------" + lock*/);
    }

}
