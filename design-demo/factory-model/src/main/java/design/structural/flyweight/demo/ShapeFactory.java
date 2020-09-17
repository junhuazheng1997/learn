package design.structural.flyweight.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kris
 * @since 2020-09-02
 */
public class ShapeFactory {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("1212", "1231", "4214124", "asdqwe");
        List<String> collect = list.stream().filter(x -> {
            System.out.println("f1"); // 只输出了f1，即当当前元素被过滤掉时，不再往下走
            return false;
        }).filter(x -> {
            System.out.println("f2");
            return true;
        }).filter(x -> {
            System.out.println("f3");
           return true;
        }).collect(Collectors.toList());
        System.out.println(collect);

    }


    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (null == circle) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }
        return circle;
    }
}
