package design.structural.flyweight.demo;

/**
 * @author kris
 * @since 2020-09-02
 */
public class Circle implements Shape {

    private String color;

    protected Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color: " + color);
    }
}
