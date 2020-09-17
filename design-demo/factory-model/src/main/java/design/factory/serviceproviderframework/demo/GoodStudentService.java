package design.factory.serviceproviderframework.demo;

import design.factory.serviceproviderframework.demo.DemoService;

/**
 * @author kris
 * @since 2020-09-17
 */
public class GoodStudentService implements DemoService {
    @Override
    public void learn() {
        System.out.println("学霸在学");
    }

    protected GoodStudentService() {}
}
