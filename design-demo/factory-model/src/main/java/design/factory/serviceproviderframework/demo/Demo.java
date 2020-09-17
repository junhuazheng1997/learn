package design.factory.serviceproviderframework.demo;

import java.util.Objects;

/**
 * @author kris
 * @since 2020-09-17
 */
public class Demo {

    public static void main(String[] args) {
        String serviceName = "student";
        DemoServices.registerProvider(serviceName, new GoodStudentProvider());
        DemoServices.newInstance(serviceName).learn();
    }

}
