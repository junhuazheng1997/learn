package design.factory.singleton.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kris
 * @since 2020-08-29
 */
public class LazySingleton {

    private LazySingleton() {}

    private static LazySingleton singleton = null;

    public static LazySingleton getInstance() {
        /**
         * 静态变量singleton存储在方法区 该引用对多个线程是可见的
         */
        if (null == singleton) singleton = new LazySingleton();
        return singleton;
    }

}
