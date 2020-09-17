package design.factory.singleton.demo;

/**
 * @author kris
 * @since 2020-08-29
 */
public class LazySyncSingleton {

    private LazySyncSingleton() {}

    private static LazySyncSingleton singleton = null;

    public synchronized static LazySyncSingleton getInstance() {
        if (null == singleton) singleton = new LazySyncSingleton();
        return singleton;
    }

}
