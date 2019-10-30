package client;
import bus.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeometricTester
{
    public static void main(String[] args)
    {
        ArrayList<Shape> shapeList = new ArrayList<>();
    }

    public static void addShape()
    {
        Scanner scanner = new Scanner(System.in);
        String shapeType = null;

        System.out.println("\n ADD SHAPE");
        System.out.println("\n CHOOSE SHAPE TYPE (SQUARE, RECTANGLE, CUBE): ");

        shapeType = scanner.nextLine();
        switch(shapeType)
        {
            case "square": createSquare();
            case "rectangle":
            case"cube":
            default: break;
        }
    }

    public static void createSquare()
    {
        Scanner scanner = new Scanner(System.in);
        String name;
        Color color;
        int xCoord;
        int yCoord;
        float length;
        String answer;

        System.out.println("\n SHAPE NAME: ");
        name = scanner.nextLine();

        System.out.println("\n COLOR (BLUE, RED, DARK): ");
        answer = scanner.nextLine();
        switch(answer)
        {
            case "blue": color = Color.BLUE; break;
            case "red": color = Color.RED; break;
            case "dark": color = Color.DARK; break;
            default: break;
        }

        System.out.println("\n X COORDINATE: ");
        xCoord = scanner.nextInt();

        System.out.println("\n X COORDINATE: ");
        yCoord = scanner.nextInt();

        System.out.println("\n SIDE LENGTH: ");
        length = scanner.nextFloat();

        Square newSquare = new Square(name, color, new Point(xCoord, yCoord), length, length);
    }

    //Remove shape by ID
    public static void removeShape(ArrayList<Shape> list)
    {
        SerialNumberComparator comparateSN = new SerialNumberComparator();
        Scanner scanner = new Scanner(System.in);
        int serialNumber = scanner.nextInt();

        for (Shape element: list)
        {
            if (serialNumber%element.getSerialNumber() == 0)
            {
                list.remove(element);
            }
        }
    }

    public static void displayShapeList(ArrayList<Shape> list)
    {
        for (Shape element : list)
        {
            System.out.print(element);
        }
    }

    public static void searchShape(ArrayList<Shape> list)
    {
        SerialNumberComparator comparateSN = new SerialNumberComparator();
        Scanner scanner = new Scanner(System.in);
        int serialNumber = scanner.nextInt();

        for (Shape element: list)
        {
            if (serialNumber%element.getSerialNumber() == 0)
            {
                System.out.println("Found: ");
                System.out.println(serialNumber);
            }
        }
    }

    public static void sortShape(ArrayList<Shape> list)
    {
        SerialNumberComparator comparateSN = new SerialNumberComparator();
        list.sort(comparateSN);
    }

    public static void displayShapeByType(ArrayList<Shape> list)
    {
        for(Shape element: list)
        {
            if(element instanceof Square)
            {
                System.out.println(element);
            }
            else if (element instanceof Rectangle)
            {
                System.out.println(element);
            }
            else if (element instanceof Cube)
            {
                System.out.println(element);
            }
        }
    }
}
