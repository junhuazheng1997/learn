package thread.basics.sync;

import java.util.Queue;

/**
 * sleep+自旋
 *
 * sleep通常用于实现上层锁。
 *
 * 缺点：
 * 1、不适合用于操作系统级别的锁，因为作为一个底层锁，其sleep时间很难设置
 * 2、sleep的时间取决于同步代码块的执行时间，sleep时间如果太短，会导致线程切换频繁
 * 3、sleep如果设置过长，会导致线程不能及时获得锁，因此无法设置一个通用的sleep值
 *
 * @author kris
 * @since 2020-08-14
 */
public class SleepSpin {

    public static void main(String[] args) {

        System.out.println();
    }

    static volatile int status = 0;

    static void unlock() {
        status = 0;
    }

    static void lock() throws InterruptedException {
        while (!compareAndSet(0, 1)) {
            Thread.sleep(10); // 锁竞争失败后，将线程休眠，从而不占用cpu资源
        }
        // get lock
    }

    static boolean compareAndSet(int except, int newValue) {
        if (status == except) {
            status = newValue;
            return false;
        }
        return true;
    }

}
