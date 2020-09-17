package thread.basics.sync;

/**
 * 通过自旋和cas来实现一个最简单的锁
 * 自旋锁：见名思意 就是一直在耗费CPU资源竞争锁
 * 缺点：耗费cpu资源，没有竞争到锁的线程会一直占用cpu资源进行cas操作
 * @author kris
 * @since 2020-08-14
 */
public class Spin {

    /**
     * 被volatile修饰的变量 对于所有线程来说都是可见的
     * 不会编译器优化而放入寄存器 而每次都从内存原始地址重新读取
     */
    static volatile int status = 0;

    static void unlock() {
        status = 0;
        System.out.println(Thread.currentThread().getName() + "释放了锁");
    }

   static void lock() {
        while (!compareAndSet(0, 1)) {
            // do something
        }
       System.out.println(Thread.currentThread().getName() + "获得了锁");
   }

    static boolean compareAndSet(int except, int newValue) {
        if (status == except) {
            status = newValue;
            return false;
        } else {
            return true;
        }
    }

}
