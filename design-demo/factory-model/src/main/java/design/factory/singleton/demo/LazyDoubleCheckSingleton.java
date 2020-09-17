package design.factory.singleton.demo;

/**
 * @author kris
 * @since 2020-08-29
 */
public class LazyDoubleCheckSingleton {

    public static String afterMemoryAllocation;
    public static void main(String[] args) {
        System.out.println(afterMemoryAllocation);
    }


    private LazyDoubleCheckSingleton() {}

    private static LazyDoubleCheckSingleton singleton = null;

    public static LazyDoubleCheckSingleton getInstance() {

        if (null == singleton) {

            /**
             * synchronized( lock )
             *
             * lock是一个实例对象
             * 在这里不能传入this 因为getInstance为静态方法
             * 如果 lock 不能保证唯一 则多线程情况下将可能失去同步效果
             *
             * 该方式下：
             *      1、第一次检查 -> 避免非必要加锁
             *      2、自身Class对象作为锁
             *          2.1、Class对象的创建不是通过构造函数创建的，而是通过类加载器生成的。
             *          2.2、每个类都有对应的用于反射该类的Class对象，每个类有且仅有一个Class对象（Heap）
             *          2.3、Class对象内部存储了方法区中该类的所有方法签名，属性签名，每个方法对应的字节码地址
             *      3、第二次检查 -> 锁竞争成功的线程再判断是否该实例是否已经存在
             *
             */
            synchronized (LazyDoubleCheckSingleton.class) {
                if (null == singleton)  {
                    /**
                     * singleton = new LazyDoubleCheckSingleton();
                     * 1、在堆内存开辟内存空间
                     * 2、在堆内存中实例化Singleton的各个参数
                     * 3、把对象指向堆内存空间
                     */
                    singleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
