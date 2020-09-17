package design.factory.serviceproviderframework.demo;

/**
 * 服务提供者接口
 * 服务提供者可以有多个
 * @author kris
 * @since 2020-09-17
 */
public interface DemoProvider {

    DemoService newService();

}

