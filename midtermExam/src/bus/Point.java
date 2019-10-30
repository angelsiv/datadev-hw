package bus;

public class Point {
    private int xCoordinate;
    private int yCoordinate;

    public int getyCoordinate() {
        return this.yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return this.xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Point() {
        this.xCoordinate = 0;
        this.yCoordinate = 0;
    }

    public Point(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public void setPoint(int x, int y) {
        this.setxCoordinate(x);
        this.setyCoordinate(y);
    }

    public String toString() {
        return this.getxCoordinate() + ", " + this.getyCoordinate();
    }
}
