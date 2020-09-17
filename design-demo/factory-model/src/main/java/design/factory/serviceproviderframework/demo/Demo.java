package design.factory.serviceproviderframework.demo;

/**
 * @author kris
 * @since 2020-09-17
 */
public class Demo {

    public static void main(String[] args) {
        String serviceName = "student_good";
        DemoServices.registerProvider(serviceName, new GoodStudentProvider());
        DemoServices.newInstance(serviceName).learn();
    }

}
