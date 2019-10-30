package bus;

public abstract class Shape implements IShape2D
{
    private int serialNumber;
    private String name;
    private Color color;
    private Point point;
    private float length;
    private float width;

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPoint() {
        return this.point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public float getLength() {
        return this.length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public Shape() {
        this.name = "";
        this.length = 0.0F;
        this.width = 0.0F;
        this.point.setPoint(0, 0);
    }

    public Shape(int serialNumber, String name, Color color, Point point, float length, float width) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.color = color;
        this.point = point;
        this.length = length;
        this.width = width;
    }

    public void moveUp() {
        this.point.setyCoordinate(this.point.getyCoordinate() + 1);
    }

    public void moveDown() {
        this.point.setyCoordinate(this.point.getyCoordinate() - 1);
    }

    public void moveLeft() {
        this.point.setxCoordinate(this.point.getxCoordinate() - 1);
    }

    public void moveRight() {
        this.point.setxCoordinate(this.point.getxCoordinate() + 1);
    }

    public String toString() {
        return "Name: " + this.name + "Color: " + this.color;
    }
}
