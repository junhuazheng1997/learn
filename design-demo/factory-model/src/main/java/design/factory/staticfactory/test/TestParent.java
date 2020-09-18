package design.factory.staticfactory.test;

/**
 * @author kris
 * @since 2020-09-18
 */
public class TestParent {

    // 构造器私有化
    private TestParent() {}

    // 提供静态工厂方法
    public static TestParent getInstance() {
        return new TestParent();
    }

    public void say() {
        System.out.println("hello world");
    }

}
