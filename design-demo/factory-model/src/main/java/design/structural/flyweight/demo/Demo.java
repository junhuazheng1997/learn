package design.structural.flyweight.demo;

/**
 * @author kris
 * @since 2020-09-02
 */
public class Demo {

    private static final String color[] = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (String c : color) {
            Circle circle = (Circle) ShapeFactory.getCircle(c);
            circle.draw();
        }
    }

}
