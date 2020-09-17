package thread.basics.sync;

/**
 * yield+自旋 实现锁
 * 优缺点：
 * 1、yield+自旋没有完全解决问题，当系统只有两个线程竞争锁的时候，yield是有效的。
 *      每次竞争失败都提示调度程序当前线程愿意放弃当前对处理器的使用
 * 2、但是如果有100个线程竞争锁，当线程1获得锁后，还有99个线程在反复自旋+yield， 最终导致CPU利用率低下
 * @author kris
 * @since 2020-08-14
 */
public class YieldSpin {

    static volatile int status = 0;

    static void lock() {
        while (!compareAndSet(0, 1)) {
            /**
             * Thread.yield(); 使当前线程让出cpu资源
             * 实现方式：
             * 将当前线程移动到所在优先调度队列的末端
             * 也就是说如果该线程处于优先级最高的调度队列且该队列只有该线程，那下次还是运行该线程
             */
            Thread.yield();
        }
        // get lock
        System.out.println(Thread.currentThread().getName() + "获得了锁");
    }

    static boolean compareAndSet(int except, int newValue) {
        if (status == except) {
            status = newValue;
            return false;
        }
        return true;
    }
}
