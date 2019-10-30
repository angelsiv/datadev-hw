package bus;

public class Rectangle extends Shape {
    public Rectangle() {
        this.setName("DefaultRectangle");
    }

    public Rectangle(int serialNumber, String name, Color color, Point point, float length, float width) {
        super(serialNumber, name, color, point, length, width);
    }

    public double calculateArea(float length, float width) {
        return (length * width);
    }

    public double calculatePerimeter(float length, float width) {
        return ((length * 2) + (width * 2));
    }

    public String displayState() {
        return this.getPoint().toString();
    }

    public String toString() {
        return super.toString() + "Area: " + this.calculateArea(this.getLength(), this.getWidth()) + "Perimeter: " + this.calculatePerimeter(this.getLength(), this.getWidth()) + "State: " + this.displayState();
    }
}
