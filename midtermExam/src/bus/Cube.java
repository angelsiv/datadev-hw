package bus;

public class Cube extends Shape {

    public Cube()
    {
        super();
        this.setName("DefaultCube");
    }

    public Cube(int serialNumber, String name, Color color, Point point, float length, float width)
    {
        super(serialNumber, name, color, point, length, width);
    }

    public double calculateArea(float length, float width) {
        return (6 * (length * width));
    }

    public double calculatePerimeter(float length, float width) {
        return (2 * ((length * width) + (length * width) + (length * width)));
    }

    public String displayState() {
        return this.getPoint().toString();
    }
}
