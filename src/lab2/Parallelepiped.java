package lab2;

public class Parallelepiped extends GeometricFigure {
    private double height;

    public Parallelepiped(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 2 * (length * width + length * height + width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }

    public double perimeter(int basePerimeter) {
        return basePerimeter;
    }

    public String perimeter(String name) {
        return name;
    }

    @Override
    public void showInformation() {
        calculateArea();
        System.out.println("This is a parallelepiped.");
        System.out.println("Height: " + height);
        System.out.println("Area: " + calculateArea());
        System.out.println("Volume: " + calculateVolume());
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
