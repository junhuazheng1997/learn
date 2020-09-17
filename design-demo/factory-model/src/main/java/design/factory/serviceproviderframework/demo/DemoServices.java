package design.factory.serviceproviderframework.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于提供注册与访问的不可实例化类
 *
 * @author kris
 * @since 2020-09-17
 */
public class DemoServices {

    private DemoServices() {} // 私有化构造方法以阻止实例化

    private static final Map<String, DemoProvider> providers = new ConcurrentHashMap<>();

    public static final String DEFAULT_PROVIDER_NAME = "demo";


    // 提供者注册API(public static)
    public static void registerDefaultProvider(DemoProvider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }
    public static void registerProvider(String name, DemoProvider p) {
        providers.put(name, p);
    }

    // 服务访问API(static factory method)
    public static DemoService newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }
    public static DemoService newInstance(String name) {
        DemoProvider p = providers.get(name);
        if (p == null)
            throw new IllegalArgumentException("No provide registered with name: " + name);
        return p.newService();
    }



}
