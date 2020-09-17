package design.factory.singleton.demo;

/**
 * @author kris
 * @since 2020-08-29
 */
public class LazyStaticInnerSingleton {

    private LazyStaticInnerSingleton() {}

    private static class SingletonHolder {
        private static final LazyStaticInnerSingleton instance = new LazyStaticInnerSingleton();
    }

    public static LazyStaticInnerSingleton getInstance() {
        return SingletonHolder.instance;
    }



}
