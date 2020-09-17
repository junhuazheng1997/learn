package design.factory.serviceproviderframework.demo;

/**
 *
 * @author kris
 * @since 2020-09-17
 */
public class GoodStudentProvider implements DemoProvider {
    @Override
    public DemoService newService() {
        return new GoodStudentService();
    }
}
