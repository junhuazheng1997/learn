package design.factory.serviceproviderframework.demo;

/**
 * 服务提供者接口
 * 服务提供者可以有多个，也可以没有提供者，使用反射按照类名对服务进行注册(存入map中)即可
 * @author kris
 * @since 2020-09-17
 */
public interface DemoProvider {

    DemoService newService();

}

